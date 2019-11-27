package com.ethjava.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
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
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class PkContractService extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50611155806100206000396000f3fe6080604052600436106100d4577c0100000000000000000000000000000000000000000000000000000000600035046327e1f7df811461010c5780632e1a7d4d146101535780632e5169471461017057806340409723146101a357806341c0e1b51461024e578063538ba4f914610256578063680c3753146102e0578063704802751461031157806371d78b121461034457806382bc45be146103595780638da5cb5b14610410578063962aeff814610425578063dbbc830b1461044f578063f2fde38b14610482578063f3e41a99146104b7575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b34801561011857600080fd5b5061013f6004803603602081101561012f57600080fd5b5035600160a060020a03166104cc565b604080519115158252519081900360200190f35b61013f6004803603602081101561016957600080fd5b5035610656565b34801561017c57600080fd5b5061013f6004803603602081101561019357600080fd5b5035600160a060020a0316610728565b3480156101af57600080fd5b506101d3600480360360408110156101c657600080fd5b50803590602001356107e9565b6040518085600160a060020a0316600160a060020a0316815260200184815260200180602001838152602001828103825284818151815260200191508051906020019060200280838360005b8381101561023757818101518382015260200161021f565b505050509050019550505050505060405180910390f35b61013f61098d565b34801561026257600080fd5b5061026b610a1d565b6040805160208082528351818301528351919283929083019185019080838360005b838110156102a557818101518382015260200161028d565b50505050905090810190601f1680156102d25780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102ec57600080fd5b506102f5610a40565b60408051600160a060020a039092168252519081900360200190f35b34801561031d57600080fd5b5061013f6004803603602081101561033457600080fd5b5035600160a060020a0316610a4f565b34801561035057600080fd5b5061026b610b33565b34801561036557600080fd5b5061013f6004803603604081101561037c57600080fd5b8135919081019060408101602082013564010000000081111561039e57600080fd5b8201836020820111156103b057600080fd5b803590602001918460208302840111640100000000831117156103d257600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600092019190915250929550610b58945050505050565b34801561041c57600080fd5b506102f5610cc0565b34801561043157600080fd5b506101d36004803603602081101561044857600080fd5b5035610ccf565b34801561045b57600080fd5b506102f56004803603602081101561047257600080fd5b5035600160a060020a0316610e6b565b34801561048e57600080fd5b506104b5600480360360208110156104a557600080fd5b5035600160a060020a0316610e86565b005b3480156104c357600080fd5b5061013f610feb565b60008054604080518082019091526006815260008051602061110a833981519152602082015290600160a060020a031633146105895760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b8381101561054e578181015183820152602001610536565b50505050905090810190601f16801561057b5780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b50600160a060020a038281166000908152600160209081526040918290205482518084019093526006835260d160020a6518189c1818190291830191909152909116151561061c5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b5050600160a060020a03166000908152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff1916905590565b60008054604080518082019091526006815260008051602061110a833981519152602082015290600160a060020a031633146106d75760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b5030318211156106e657600080fd5b60008054604051600160a060020a039091169184156108fc02918591818181858888f1935050505015801561071f573d6000803e3d6000fd5b50600192915050565b3360009081526001602090815260408083205481518083019092526006825260d160020a6518189c181819029282019290925290600160a060020a031615156107b65760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b505060028054600160a060020a03831673ffffffffffffffffffffffffffffffffffffffff199091161790556001919050565b600254604080518082019091526006815260d160020a6518189c1818190260208201526000918291606091839190600160a060020a031615156108715760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b50600254604080517f4040972300000000000000000000000000000000000000000000000000000000815260048101899052602481018890529051600160a060020a0390921691634040972391604480820192600092909190829003018186803b1580156108de57600080fd5b505afa1580156108f2573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052608081101561091b57600080fd5b815160208301516040840180519294919382019264010000000081111561094157600080fd5b8201602081018481111561095457600080fd5b815185602082028301116401000000008211171561097157600080fd5b505060209190910151949b939a50985092965090945050505050565b60008054604080518082019091526006815260008051602061110a833981519152602082015290600160a060020a03163314610a0e5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b50600054600160a060020a0316ff5b604080518082019091526006815260d160020a6518189c18181902602082015281565b600254600160a060020a031681565b60008054604080518082019091526006815260008051602061110a833981519152602082015290600160a060020a03163314610ad05760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b50600160a060020a038281166000908152600160205260409020541615610af657600080fd5b50600160a060020a03166000818152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff191690921790915590565b604080518082019091526006815260008051602061110a833981519152602082015281565b600254604080518082019091526006815260d160020a6518189c181819026020820152600091600160a060020a03161515610bd85760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b506002546040517f91d12891000000000000000000000000000000000000000000000000000000008152336004820181815260248301879052606060448401908152865160648501528651600160a060020a03909516946391d12891948993899390929091608401906020808601910280838360005b83811015610c66578181015183820152602001610c4e565b50505050905001945050505050602060405180830381600087803b158015610c8d57600080fd5b505af1158015610ca1573d6000803e3d6000fd5b505050506040513d6020811015610cb757600080fd5b50519392505050565b600054600160a060020a031681565b600254604080518082019091526006815260d160020a6518189c1818190260208201526000918291606091839190600160a060020a03161515610d575760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b50600254604080517f962aeff8000000000000000000000000000000000000000000000000000000008152600481018890529051600160a060020a039092169163962aeff891602480820192600092909190829003018186803b158015610dbd57600080fd5b505afa158015610dd1573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526080811015610dfa57600080fd5b8151602083015160408401805192949193820192640100000000811115610e2057600080fd5b82016020810184811115610e3357600080fd5b8151856020820283011164010000000082111715610e5057600080fd5b505060209190910151949a9399509750929550909350505050565b600160205260009081526040902054600160a060020a031681565b600054604080518082019091526006815260008051602061110a833981519152602082015290600160a060020a03163314610f065760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b50604080518082019091526006815260d160020a6518189c181819026020820152600160a060020a0382161515610f825760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b5060008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600254604080518082019091526006815260d160020a6518189c181819026020820152600091600160a060020a0316151561106b5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561054e578181015183820152602001610536565b50600260009054906101000a9004600160a060020a0316600160a060020a031663f3e41a996040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156110d857600080fd5b505af11580156110ec573d6000803e3d6000fd5b505050506040513d602081101561110257600080fd5b505190509056fe3031383030310000000000000000000000000000000000000000000000000000a165627a7a72305820dbc072c028120085a691ac49861140b9d559c1652980c2dbb908005c88b6ae2d0029";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_SETPKCONTRACTADDR = "setPkContractAddr";

    public static final String FUNC_GETPKDATABYROUND = "getPkDataByRound";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_PKCONTRACTADDR = "pkContractAddr";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_ADDPKDATA = "addPkData";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_GETPKDATA = "getPkData";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_ADDROUND = "addRound";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected PkContractService(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PkContractService(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PkContractService(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PkContractService(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> deleteAdmin(String addr) {
        final Function function = new Function(
                FUNC_DELETEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger _value, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> setPkContractAddr(String _pkContractAddr) {
        final Function function = new Function(
                FUNC_SETPKCONTRACTADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _pkContractAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>> getPkDataByRound(BigInteger round, byte[] no) {
        final Function function = new Function(FUNC_GETPKDATABYROUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(round), 
                new org.web3j.abi.datatypes.generated.Bytes32(no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>>(function,
                new Callable<Tuple4<String, byte[], List<byte[]>, BigInteger>>() {
                    @Override
                    public Tuple4<String, byte[], List<byte[]>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, byte[], List<byte[]>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> kill(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> ZERO_ADDRESS() {
        final Function function = new Function(FUNC_ZERO_ADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> pkContractAddr() {
        final Function function = new Function(FUNC_PKCONTRACTADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addAdmin(String addr) {
        final Function function = new Function(
                FUNC_ADDADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> NOT_OWNER() {
        final Function function = new Function(FUNC_NOT_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addPkData(byte[] no, List<byte[]> data) {
        final Function function = new Function(
                FUNC_ADDPKDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(no), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>> getPkData(byte[] no) {
        final Function function = new Function(FUNC_GETPKDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>>(function,
                new Callable<Tuple4<String, byte[], List<byte[]>, BigInteger>>() {
                    @Override
                    public Tuple4<String, byte[], List<byte[]>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, byte[], List<byte[]>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> adminMap(String param0) {
        final Function function = new Function(FUNC_ADMINMAP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addRound() {
        final Function function = new Function(
                FUNC_ADDROUND, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ReceivedHpbEventResponse> getReceivedHpbEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVEDHPB_EVENT, transactionReceipt);
        ArrayList<ReceivedHpbEventResponse> responses = new ArrayList<ReceivedHpbEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedHpbEventResponse typedResponse = new ReceivedHpbEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedHpbEventResponse> receivedHpbEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReceivedHpbEventResponse>() {
            @Override
            public ReceivedHpbEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVEDHPB_EVENT, log);
                ReceivedHpbEventResponse typedResponse = new ReceivedHpbEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedHpbEventResponse> receivedHpbEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVEDHPB_EVENT));
        return receivedHpbEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    @Deprecated
    public static PkContractService load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PkContractService(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PkContractService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PkContractService(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PkContractService load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PkContractService(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PkContractService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PkContractService(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PkContractService> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PkContractService.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PkContractService> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PkContractService.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PkContractService> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PkContractService.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PkContractService> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PkContractService.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ReceivedHpbEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
