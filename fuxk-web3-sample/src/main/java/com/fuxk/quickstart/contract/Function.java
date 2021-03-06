package com.fuxk.quickstart.contract;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Function extends Contract {
    private static final String BINARY = "{\n"
            + "\t\"functionDebugData\": {},\n"
            + "\t\"generatedSources\": [],\n"
            + "\t\"linkReferences\": {},\n"
            + "\t\"object\": \"608060405234801561001057600080fd5b5061025b806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063771602f71461003b578063b67d77c51461006b575b600080fd5b610055600480360381019061005091906100dc565b61009b565b604051610062919061012b565b60405180910390f35b610085600480360381019061008091906100dc565b6100b1565b604051610092919061012b565b60405180910390f35b600081836100a99190610146565b905092915050565b600081836100bf919061019c565b905092915050565b6000813590506100d68161020e565b92915050565b600080604083850312156100f3576100f2610209565b5b6000610101858286016100c7565b9250506020610112858286016100c7565b9150509250929050565b610125816101d0565b82525050565b6000602082019050610140600083018461011c565b92915050565b6000610151826101d0565b915061015c836101d0565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115610191576101906101da565b5b828201905092915050565b60006101a7826101d0565b91506101b2836101d0565b9250828210156101c5576101c46101da565b5b828203905092915050565b6000819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600080fd5b610217816101d0565b811461022257600080fd5b5056fea26469706673582212206f7e5cacdb4b9afbed7587b114c05ebf4aea1803e4e96f35f2064e5c2997200364736f6c63430008070033\",\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x25B DUP1 PUSH2 0x20 PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x4 CALLDATASIZE LT PUSH2 0x36 JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x771602F7 EQ PUSH2 0x3B JUMPI DUP1 PUSH4 0xB67D77C5 EQ PUSH2 0x6B JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x55 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x50 SWAP2 SWAP1 PUSH2 0xDC JUMP JUMPDEST PUSH2 0x9B JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x62 SWAP2 SWAP1 PUSH2 0x12B JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x85 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x80 SWAP2 SWAP1 PUSH2 0xDC JUMP JUMPDEST PUSH2 0xB1 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x92 SWAP2 SWAP1 PUSH2 0x12B JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH1 0x0 DUP2 DUP4 PUSH2 0xA9 SWAP2 SWAP1 PUSH2 0x146 JUMP JUMPDEST SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 DUP4 PUSH2 0xBF SWAP2 SWAP1 PUSH2 0x19C JUMP JUMPDEST SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0xD6 DUP2 PUSH2 0x20E JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x40 DUP4 DUP6 SUB SLT ISZERO PUSH2 0xF3 JUMPI PUSH2 0xF2 PUSH2 0x209 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x101 DUP6 DUP3 DUP7 ADD PUSH2 0xC7 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x20 PUSH2 0x112 DUP6 DUP3 DUP7 ADD PUSH2 0xC7 JUMP JUMPDEST SWAP2 POP POP SWAP3 POP SWAP3 SWAP1 POP JUMP JUMPDEST PUSH2 0x125 DUP2 PUSH2 0x1D0 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x140 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x11C JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x151 DUP3 PUSH2 0x1D0 JUMP JUMPDEST SWAP2 POP PUSH2 0x15C DUP4 PUSH2 0x1D0 JUMP JUMPDEST SWAP3 POP DUP3 PUSH32 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF SUB DUP3 GT ISZERO PUSH2 0x191 JUMPI PUSH2 0x190 PUSH2 0x1DA JUMP JUMPDEST JUMPDEST DUP3 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1A7 DUP3 PUSH2 0x1D0 JUMP JUMPDEST SWAP2 POP PUSH2 0x1B2 DUP4 PUSH2 0x1D0 JUMP JUMPDEST SWAP3 POP DUP3 DUP3 LT ISZERO PUSH2 0x1C5 JUMPI PUSH2 0x1C4 PUSH2 0x1DA JUMP JUMPDEST JUMPDEST DUP3 DUP3 SUB SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x11 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x217 DUP2 PUSH2 0x1D0 JUMP JUMPDEST DUP2 EQ PUSH2 0x222 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 PUSH16 0x7E5CACDB4B9AFBED7587B114C05EBF4A 0xEA XOR SUB 0xE4 0xE9 PUSH16 0x35F2064E5C2997200364736F6C634300 ADDMOD SMOD STOP CALLER \",\n"
            + "\t\"sourceMap\": \"59:201:0:-:0;;;;;;;;;;;;;;;;;;;\"\n"
            + "}";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_SUB = "sub";

    @Deprecated
    protected Function(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Function(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Function(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Function(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

//    public RemoteCall<TransactionReceipt> add(BigInteger a, BigInteger b) {
//        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
//                FUNC_ADD,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a),
//                new org.web3j.abi.datatypes.generated.Uint256(b)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }


    public RemoteCall<org.web3j.abi.datatypes.generated.Uint256> add(BigInteger a, BigInteger b) throws IOException {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADD,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a),
                        new org.web3j.abi.datatypes.generated.Uint256(b)),
                Arrays.<TypeReference<?>>asList(new TypeReference<org.web3j.abi.datatypes.generated.Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }


    public RemoteCall<TransactionReceipt> sub(BigInteger a, BigInteger b) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Function> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Function.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Function> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Function.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Function> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Function.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Function> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Function.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Function load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Function(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Function load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Function(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Function load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Function(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Function load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Function(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
