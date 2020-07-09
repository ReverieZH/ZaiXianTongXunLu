package cn.com.dao;

import cn.com.bean.Contracts;

import java.util.List;

/**
* @Description: 联系人服务的接口
* @Date:
* @Author:
*/
public interface IContractDao {
    public void addContract(Contracts contracts) throws Exception;
    public void deleteContract(String cid) throws Exception;
    public void updateContract(Contracts contracts) throws Exception;
    public Contracts getContractByID(String pid) throws Exception;
    public List<Contracts> getContractList(String username, String name, String phone, String number, String workspace, String role) throws Exception;
}
