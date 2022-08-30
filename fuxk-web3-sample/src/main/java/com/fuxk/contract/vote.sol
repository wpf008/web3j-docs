// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract vote {

    struct Voter {
        uint weight;
        bool isVoted;
        address delegate;
        uint vote;
    }

    struct Proposal {
        bytes32 proposalName;
        uint count;
    }

    address public chairPerson;

    mapping(address => Voter) public voters;

    Proposal[] public proposals;

    constructor (bytes32[] memory proposalNames){
        chairPerson = msg.sender;
        voters[chairPerson].weight = 1;
        for (uint i = 0; i < proposalNames.length; i++) {
            proposals.push(Proposal({
            proposalName : proposalNames[i],
            count : 0
            }));
        }
    }

    function giveRightVote(address voter) external {
        require(msg.sender == chairPerson, "Only chairperson can give right to vote.");
        require(!voters[voter].isVoted, "The voter already voted.");
        require(voters[voter].weight == 0);
        voters[voter].weight = 1;
    }

    function delegate(address to) external {
        require(to != msg.sender, "Self-delegation is disallowed.");
        Voter storage voter = voters[to];
        require(!voter.isVoted, "You already voted.");
        while (voters[to].delegate != address(0)) {
            to = voters[to].delegate;
            require(to != msg.sender, "Found loop in delegation.");
        }
        Voter storage delegate_ = voters[to];
        require(delegate_.weight >= 1);
        voter.isVoted = true;
        voter.delegate = to;

        if (delegate_.isVoted) {
            proposals[delegate_.vote].count += voter.weight;
        } else {
            delegate_.weight += voter.weight;
        }
    }

    function doVote(uint proposal) external {
        Voter storage sender = voters[msg.sender];
        require(!sender.isVoted, "Already voted.");
        sender.isVoted = true;
        sender.vote = proposal;

        proposals[proposal].count += sender.weight;
    }

    function winningProposal() external view returns (uint winningProposal_){
        uint winningVoteCount = 0;
        for (uint p = 0; p < proposals.length; p++) {
            if (proposals[p].count > winningVoteCount) {
                winningVoteCount = proposals[p].count;
                winningProposal_ = p;
            }
        }
    }

    function winnerName() external view returns (bytes32 winnerName_){
        uint winningVoteCount = 0;
        uint winningProposal_ = 0;
        for (uint p = 0; p < proposals.length; p++) {
            if (proposals[p].count > winningVoteCount) {
                winningVoteCount = proposals[p].count;
                winningProposal_ = p;
            }
        }
        winnerName_ = proposals[winningVoteCount].proposalName;
    }


}
