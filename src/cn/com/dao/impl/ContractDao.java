package cn.com.dao.impl;

import cn.com.bean.Contracts;
import cn.com.dao.IContractDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ContractDao implements IContractDao {
    @Override
    public void addContract(Contracts contracts) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        if(con==null){
            throw new Exception("数据库连接失败");
        }
        String error=new String();
        String sql="{call addContracts(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement cs=con.prepareCall(sql);
//        call updateContacts('reverie001','任泽华','男','2010-2-2',1,'1344980837','8552729','15291613691','学校','小区','723000','reverie',1,@msg);

        //pname nvarchar(20),psex char(1),pbirth varchar(10),ppage int(11),pqq varchar(12),pnumber varchar(13),pphone varchar(11),pworkspace varchar(15),paddress varchar(30),ppostcode varchar(8),pusername varchar(8),prole int(11),out message varchar(30)
        cs.setString(1,contracts.getName());
        cs.setString(2,contracts.getSex());
        cs.setString(3,contracts.getBirth());
        cs.setObject(4,contracts.getAge());
        cs.setString(5,contracts.getQq());
        cs.setString(6,contracts.getNumber());
        cs.setString(7,contracts.getPhone());
        cs.setString(8,contracts.getEmail());
        cs.setString(9,contracts.getWorkspace());
        cs.setString(10,contracts.getAddress());
        cs.setString(11,contracts.getPostcode());
        cs.setString(12,contracts.getUsername());
        cs.setString(13,contracts.getRole());
        cs.registerOutParameter(14, Types.VARCHAR);
        int row=cs.executeUpdate();
        error=cs.getString(14);
        if(error!=null)
            throw new Exception(error);
        JDBCUtils.close(con,cs);
    }

    @Override
    public void deleteContract(String cid) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        CallableStatement cs=con.prepareCall("{call deleteContracts(?)}");
        cs.setString(1,cid);
        cs.executeUpdate();
        JDBCUtils.close(con,cs);
    }

    @Override
    public void updateContract(Contracts contracts) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        String error=new String();
        CallableStatement cs=con.prepareCall("{call updateContracts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString(1,contracts.getCid());
        cs.setString(2,contracts.getName());
        cs.setString(3,contracts.getSex());
        cs.setString(4,contracts.getBirth());
        cs.setObject(5,contracts.getAge());
        cs.setString(6,contracts.getQq());
        cs.setString(7,contracts.getNumber());
        cs.setString(8,contracts.getPhone());
        cs.setString(9,contracts.getEmail());
        cs.setString(10,contracts.getWorkspace());
        cs.setString(11,contracts.getAddress());
        cs.setString(12,contracts.getPostcode());
        cs.setString(13,contracts.getUsername());
        cs.setString(14,contracts.getRole());
        cs.registerOutParameter(15, Types.VARCHAR);
        cs.executeUpdate();
        error=cs.getString(15);
        if(error!=null)
            throw new Exception(error);
        JDBCUtils.close(con,cs);
    }

    @Override
    public Contracts getContractByID(String pid) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        CallableStatement cs=con.prepareCall("{call getContractByID(?)}");
        cs.setString(1,pid);
        ResultSet rs=cs.executeQuery();
        if(!rs.next())
            throw new Exception("无联系人记录");
        Contracts contracts=new Contracts();
        contracts.setCid(rs.getString("cid"));
        contracts.setName(rs.getString("name"));
        contracts.setSex(rs.getString("sex"));
        contracts.setBirth(rs.getString("birth"));
        System.out.println(rs.getInt("age"));
        if(rs.getObject("age")==null) {
            contracts.setAge(null);
        }else{
            contracts.setAge((Integer) rs.getObject("age"));
        }
        contracts.setQq(rs.getString("qq"));
        contracts.setNumber(rs.getString("number"));
        contracts.setPhone(rs.getString("phone"));
        contracts.setEmail(rs.getString("email"));
        contracts.setWorkspace(rs.getString("workspace"));
        contracts.setAddress(rs.getString("address"));
        contracts.setPostcode(rs.getString("postcode"));
        contracts.setUsername(rs.getString("username"));
        contracts.setRole(rs.getString("role"));
        JDBCUtils.close(con,cs,rs);
        return contracts;
    }

    @Override
    public List<Contracts> getContractList(String username, String name, String phone, String number, String workspace,String role) throws Exception {
        Connection con = JDBCUtils.getConnecion();
        CallableStatement cs=con.prepareCall("{call getContractsList(?,?,?,?,?,?)}");
        cs.setString(1,username);
        cs.setString(2,name);
        cs.setString(3,phone);
        cs.setString(4,number);
        cs.setString(5,workspace);
        cs.setString(6,role);
        ResultSet rs=cs.executeQuery();
        List<Contracts> contractsList=new ArrayList<>();
        while(rs.next()){
            Contracts contracts=new Contracts();
            contracts.setCid(rs.getString("cid"));
            contracts.setName(rs.getString("name"));
            contracts.setSex(rs.getString("sex"));
            contracts.setBirth(rs.getString("birth"));
            if(rs.getObject("age")==null) {
                contracts.setAge(null);
            }else{
                contracts.setAge((Integer) rs.getObject("age"));
            }
            contracts.setQq(rs.getString("qq"));
            contracts.setNumber(rs.getString("number"));
            contracts.setPhone(rs.getString("phone"));
            contracts.setEmail(rs.getString("email"));
            contracts.setWorkspace(rs.getString("workspace"));
            contracts.setAddress(rs.getString("address"));
            contracts.setPostcode(rs.getString("postcode"));
            contracts.setUsername(rs.getString("username"));
            contracts.setRole(rs.getString("role"));
            contractsList.add(contracts);
        }
        JDBCUtils.close(con,cs,rs);
        return contractsList;
    }

  /* public static void main(String[] args) throws  Exception{
        //Contracts contracts=new Contracts("reverie001","张三","男","2010-2-2",1,"1344980837","8552729","15291613691","学校","小区","723000","zhangsan",1);
            ContractDaoImpl test=new ContractDaoImpl();
          //  test.updateContract(contracts);

        //System.out.println(test.getContractByID("reverie002").toString());
        List<Contracts> contractsList=test.getContractList(null,null,null,null,null,0);
        for (Contracts c:contractsList) {
            System.out.println(c.toString());
        }
    }*/
}
