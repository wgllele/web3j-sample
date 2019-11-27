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
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
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
public class LotteryContract extends Contract {
    private static final String BINARY = "6000805433600160a060020a031991821617808355600160a060020a031680835260016020819052604080852080548516909317909255608084815261018090925260e084815261010085905261012085905261014085905261016085905260a081905260c08590526002805492830180825595527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace6003909202918201805490941684559192916100d5917f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf019060056100e8565b506040820151816002015550505061019c565b60018301918390821561016b5791602002820160005b8382111561013c57835183826101000a81548160ff021916908360ff16021790555092602001926001016020816000010492830192600103026100fe565b80156101695782816101000a81549060ff021916905560010160208160000104928301926001030261013c565b505b5061017792915061017b565b5090565b61019991905b8082111561017757805460ff19168155600101610181565b90565b610efc806101ab6000396000f3fe6080604052600436106100c9577c0100000000000000000000000000000000000000000000000000000000600035046327e1f7df81146101015780632e1a7d4d1461014857806335d5d3111461016557806341c0e1b51461018c578063538ba4f9146101945780635f2ef3b01461021e578063704802751461028257806371d78b12146102b55780637e3d8803146102ca5780638da5cb5b14610317578063dbbc830b14610348578063e9e085e41461037b578063f2fde38b146103a5578063f3c2dc7e146103da575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b34801561010d57600080fd5b506101346004803603602081101561012457600080fd5b5035600160a060020a0316610446565b604080519115158252519081900360200190f35b6101346004803603602081101561015e57600080fd5b50356105d2565b34801561017157600080fd5b5061017a6106a4565b60408051918252519081900360200190f35b6101346106af565b3480156101a057600080fd5b506101a961073f565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101e35781810151838201526020016101cb565b50505050905090810190601f1680156102105780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561022a57600080fd5b50610233610764565b604051600160a060020a0384168152602081018360a080838360005b8381101561026757818101518382015260200161024f565b50505050905001828152602001935050505060405180910390f35b34801561028e57600080fd5b50610134600480360360208110156102a557600080fd5b5035600160a060020a0316610848565b3480156102c157600080fd5b506101a961092c565b3480156102d657600080fd5b506102f4600480360360208110156102ed57600080fd5b5035610951565b60408051600160a060020a03909316835260208301919091528051918290030190f35b34801561032357600080fd5b5061032c610987565b60408051600160a060020a039092168252519081900360200190f35b34801561035457600080fd5b5061032c6004803603602081101561036b57600080fd5b5035600160a060020a0316610996565b34801561038757600080fd5b506102336004803603602081101561039e57600080fd5b50356109b1565b3480156103b157600080fd5b506103d8600480360360208110156103c857600080fd5b5035600160a060020a0316610a8d565b005b3480156103e657600080fd5b50610134600480360360c08110156103fd57600080fd5b6040805160a0818101909252600160a060020a0384351693928301929160c08301919060208401906005908390839080828437600092019190915250919450610bf49350505050565b600080546040805180820190915260068152600080516020610e91833981519152602082015290600160a060020a031633146105035760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156104c85781810151838201526020016104b0565b50505050905090810190601f1680156104f55780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b50600160a060020a0382811660009081526001602090815260409182902054825180840190935260068352600080516020610eb18339815191529183019190915290911615156105985760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b5050600160a060020a03166000908152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff1916905590565b600080546040805180820190915260068152600080516020610e91833981519152602082015290600160a060020a031633146106535760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b50303182111561066257600080fd5b60008054604051600160a060020a039091169184156108fc02918591818181858888f1935050505015801561069b573d6000803e3d6000fd5b50600192915050565b600254600019015b90565b600080546040805180820190915260068152600080516020610e91833981519152602082015290600160a060020a031633146107305760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b50600054600160a060020a0316ff5b6040805180820190915260068152600080516020610eb1833981519152602082015281565b600061076e610dc0565b6002546000906000190180151561078457600080fd5b600280548290811061079257fe5b600091825260209091206003909102015460028054600160a060020a0390921691839081106107bd57fe5b90600052602060002090600302016001016002838154811015156107dd57fe5b600091825260208220600390910201600201546040805160a0810191829052919284916005918390855b825461010083900a900460ff168152602060019283018181049485019490930390920291018084116108075790505050505050915093509350935050909192565b600080546040805180820190915260068152600080516020610e91833981519152602082015290600160a060020a031633146108c95760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b50600160a060020a0382811660009081526001602052604090205416156108ef57600080fd5b50600160a060020a03166000818152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff191690921790915590565b6040805180820190915260068152600080516020610e91833981519152602082015281565b600280548290811061095f57fe5b600091825260209091206003909102018054600290910154600160a060020a03909116915082565b600054600160a060020a031681565b600160205260009081526040902054600160a060020a031681565b60006109bb610dc0565b60008315156109c957600080fd5b60028054859081106109d757fe5b600091825260209091206003909102015460028054600160a060020a039092169186908110610a0257fe5b9060005260206000209060030201600101600286815481101515610a2257fe5b600091825260208220600390910201600201546040805160a0810191829052919284916005918390855b825461010083900a900460ff16815260206001928301818104948501949093039092029101808411610a4c5750979c949b5094995092975050505050505050565b6000546040805180820190915260068152600080516020610e91833981519152602082015290600160a060020a03163314610b0d5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b506040805180820190915260068152600080516020610eb18339815191526020820152600160a060020a0382161515610b8b5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b5060008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b33600090815260016020908152604080832054815180830190925260068252600080516020610eb18339815191529282019290925290600160a060020a03161515610c845760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156104c85781810151838201526020016104b0565b5060408051606081018252600160a060020a038581168252602082018581524293830193909352600280546001810180835560009290925283517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace6003909202918201805473ffffffffffffffffffffffffffffffffffffffff19169190941617835593519093610d3b917f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf909101906005610ddf565b506040820151816002015550505082600160a060020a03167f45e63290dfb7732e86dadca897e5d80f665d44a932a793bd88f3dec49bed6b9783426040518083600560200280838360005b83811015610d9e578181015183820152602001610d86565b505050509050018281526020019250505060405180910390a250600192915050565b60a0604051908101604052806005906020820280388339509192915050565b600183019183908215610e625791602002820160005b83821115610e3357835183826101000a81548160ff021916908360ff1602179055509260200192600101602081600001049283019260010302610df5565b8015610e605782816101000a81549060ff0219169055600101602081600001049283019260010302610e33565b505b50610e6e929150610e72565b5090565b6106ac91905b80821115610e6e57805460ff19168155600101610e7856fe30313830303100000000000000000000000000000000000000000000000000003031383030320000000000000000000000000000000000000000000000000000a165627a7a72305820aeb0833e0f3895b8c8246767b614ff1f92475372f2bcc68ffa45961bc151493b0029";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_GETCURRENTLOTTERYINDEX = "getCurrentLotteryIndex";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_GETCURRENTLOTTERY = "getCurrentLottery";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_LOTTERYS = "lotterys";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_GETLOTTERYBYINDEX = "getLotteryByIndex";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_ADDLOTTERY = "addLottery";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ADDLOTTERY_EVENT = new Event("AddLottery", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected LotteryContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LotteryContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LotteryContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LotteryContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<BigInteger> getCurrentLotteryIndex() {
        final Function function = new Function(FUNC_GETCURRENTLOTTERYINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> getCurrentLottery() {
        final Function function = new Function(FUNC_GETCURRENTLOTTERY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint8>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
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

    public RemoteFunctionCall<Tuple2<String, BigInteger>> lotterys(BigInteger param0) {
        final Function function = new Function(FUNC_LOTTERYS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<String, BigInteger>>(function,
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
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

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> getLotteryByIndex(BigInteger index) {
        final Function function = new Function(FUNC_GETLOTTERYBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint8>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addLottery(String addr, List<BigInteger> data) {
        final Function function = new Function(
                FUNC_ADDLOTTERY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.generated.StaticArray5<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.datatypes.generated.Uint8.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.generated.Uint8.class))), 
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

    public List<AddLotteryEventResponse> getAddLotteryEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDLOTTERY_EVENT, transactionReceipt);
        ArrayList<AddLotteryEventResponse> responses = new ArrayList<AddLotteryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddLotteryEventResponse typedResponse = new AddLotteryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.blockTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddLotteryEventResponse> addLotteryEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddLotteryEventResponse>() {
            @Override
            public AddLotteryEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDLOTTERY_EVENT, log);
                AddLotteryEventResponse typedResponse = new AddLotteryEventResponse();
                typedResponse.log = log;
                typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.blockTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddLotteryEventResponse> addLotteryEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDLOTTERY_EVENT));
        return addLotteryEventFlowable(filter);
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
    public static LotteryContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LotteryContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LotteryContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LotteryContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LotteryContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LotteryContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LotteryContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryContract.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<LotteryContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryContract.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class ReceivedHpbEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class AddLotteryEventResponse extends BaseEventResponse {
        public String addr;

        public List<BigInteger> data;

        public BigInteger blockTime;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
