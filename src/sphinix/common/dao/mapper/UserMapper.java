package ups.sysadmin.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ups.sysadmin.model.User;

public class UserMapper implements RowMapper<User> {

	
	@Override
	public User mapRow(ResultSet rs, int line) throws SQLException {
		User user = new User();
		user.setUserSysNumber(rs.getLong("USR_SYS_NR"));
		user.setUserManagerSysNumber(rs.getLong("MGR_USR_SYS_NR"));
		user.setUserNumber(rs.getString("USR_NR"));
		user.setUserStatusCode(rs.getString("USR_STS_CD"));
		user.setCountryCode(rs.getString("CNY_CD"));
		user.setUserRoleSysNr(rs.getLong("USR_RL_SYS_NR"));
		user.setRecodeEffEndDate(rs.getDate("REC_EFF_END_DT"));
		user.setTransLangCode(rs.getString("TSL_LGU_CD"));
		user.setUserRoleCategorySysNr(rs.getLong("USR_RL_CGY_SYS_NR"));
		user.setArWRKGrpSysNumber(rs.getString("AR_WRK_GRP_SYS_NR"));
		return user;
	}

}
