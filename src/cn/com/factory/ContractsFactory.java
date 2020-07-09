package cn.com.factory;

import cn.com.dao.IContractDao;
import cn.com.dao.impl.ContractDao;

public class ContractsFactory {
    public static IContractDao getContractsInstance(){
        return new ContractDao();
    }
}
