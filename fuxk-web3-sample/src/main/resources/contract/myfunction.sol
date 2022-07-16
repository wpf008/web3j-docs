// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8;

contract myfunction{

    function add(uint a,uint b) public pure returns (uint) {
        return a+b;
    }
    function sub(uint a,uint b) public pure returns (uint) {
        return a-b;
    }
}