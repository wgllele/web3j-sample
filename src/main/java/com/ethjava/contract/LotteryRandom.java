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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.StaticArray5;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class LotteryRandom extends Contract {
    private static final String BINARY = "6080604090815260008054600160a060020a03199081163317808355600160a060020a031680835260016020529290912080549091169091179055610a63806100496000396000f3fe60806040526004361061009d577c0100000000000000000000000000000000000000000000000000000000600035046302e4af0181146100d557806327e1f7df146101225780632e1a7d4d1461016957806341c0e1b514610186578063538ba4f91461018e578063704802751461021857806371d78b121461024b5780638da5cb5b14610260578063dbbc830b14610291578063f2fde38b146102c4575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b3480156100e157600080fd5b506100ea6102f9565b604051808260a080838360005b8381101561010f5781810151838201526020016100f7565b5050505090500191505060405180910390f35b34801561012e57600080fd5b506101556004803603602081101561014557600080fd5b5035600160a060020a0316610415565b604080519115158252519081900360200190f35b6101556004803603602081101561017f57600080fd5b50356105b3565b610155610685565b34801561019a57600080fd5b506101a3610715565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101dd5781810151838201526020016101c5565b50505050905090810190601f16801561020a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561022457600080fd5b506101556004803603602081101561023b57600080fd5b5035600160a060020a031661074c565b34801561025757600080fd5b506101a3610830565b34801561026c57600080fd5b50610275610855565b60408051600160a060020a039092168252519081900360200190f35b34801561029d57600080fd5b50610275600480360360208110156102b457600080fd5b5035600160a060020a0316610864565b3480156102d057600080fd5b506102f7600480360360208110156102e757600080fd5b5035600160a060020a031661087f565b005b6103016109f8565b6103096109f8565b50506040805160a081018252600319439081014060c08301524260e08084018290528451808503909101815261010084018552805160209182012060ff600991829006811686528651600219860140818501528088018590528751808203890181526060918201895280519085012083900682168488015287516001198701408186015280890186905288518082038a018152908201895280519085012083900682168789015287516000198701408186015280890186905288518082038a018152908201895280519085012083900682168188015287519540868501528588019490945286518086038801815294909301909552825192019190912092909206909116608082015290565b600080546040805180820190915260068152600080516020610a18833981519152602082015290600160a060020a031633146104d25760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b8381101561049757818101518382015260200161047f565b50505050905090810190601f1680156104c45780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b50600160a060020a03828116600090815260016020908152604091829020548251808401909352600683527f30313830303200000000000000000000000000000000000000000000000000009183019190915290911615156105795760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561049757818101518382015260200161047f565b5050600160a060020a03166000908152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff1916905590565b600080546040805180820190915260068152600080516020610a18833981519152602082015290600160a060020a031633146106345760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561049757818101518382015260200161047f565b50303182111561064357600080fd5b60008054604051600160a060020a039091169184156108fc02918591818181858888f1935050505015801561067c573d6000803e3d6000fd5b50600192915050565b600080546040805180820190915260068152600080516020610a18833981519152602082015290600160a060020a031633146107065760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561049757818101518382015260200161047f565b50600054600160a060020a0316ff5b60408051808201909152600681527f3031383030320000000000000000000000000000000000000000000000000000602082015281565b600080546040805180820190915260068152600080516020610a18833981519152602082015290600160a060020a031633146107cd5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561049757818101518382015260200161047f565b50600160a060020a0382811660009081526001602052604090205416156107f357600080fd5b50600160a060020a03166000818152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff191690921790915590565b6040805180820190915260068152600080516020610a18833981519152602082015281565b600054600160a060020a031681565b600160205260009081526040902054600160a060020a031681565b6000546040805180820190915260068152600080516020610a18833981519152602082015290600160a060020a031633146108ff5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561049757818101518382015260200161047f565b5060408051808201909152600681527f30313830303200000000000000000000000000000000000000000000000000006020820152600160a060020a038216151561098f5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561049757818101518382015260200161047f565b5060008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60a060405190810160405280600590602082028038833950919291505056fe3031383030310000000000000000000000000000000000000000000000000000a165627a7a72305820c433f0cc691531e38dd2ebcb2665b52d442102501276432975051d03c676b6b30029";

    public static final String FUNC_GENERATERANDOM = "generateRandom";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected LotteryRandom(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LotteryRandom(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LotteryRandom(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LotteryRandom(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<List> generateRandom() {
        final Function function = new Function(FUNC_GENERATERANDOM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray5<Uint8>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
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

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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
    public static LotteryRandom load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryRandom(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LotteryRandom load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryRandom(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LotteryRandom load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LotteryRandom(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LotteryRandom load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LotteryRandom(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LotteryRandom> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryRandom.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<LotteryRandom> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryRandom.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryRandom> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryRandom.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryRandom> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryRandom.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
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
