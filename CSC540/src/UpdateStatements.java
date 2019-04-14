import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hospital.bean.Medical_Record;

public class UpdateStatements {
	InsertStatement insert = new InsertStatement();
	static Statement st = Connection.getInstance();
	static ResultSet rs = null;
	
	public static void updateBillingAccount(String recordID, String treatmentCharge) {
		String query = "UPDATE Billing_Account SET Treatment_Fee=Treatment_Fee+"+Integer.parseInt(treatmentCharge)+" WHERE Record_ID="+recordID;
		System.out.println(query);
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
