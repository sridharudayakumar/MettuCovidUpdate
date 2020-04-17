package com.mettucovid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mettucovid.dto.CaseNumbers;
import com.mettucovid.dto.Patient;
import com.mettucovid.util.ConnectionUtil;




public class PatientDao {

	public static int insertPatient(Patient patient) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();

		PreparedStatement ps = null;
		// Employee employee = new Employee();

		String sql = "INSERT INTO patients(firstName,lastName,age,gender,address,region,country,phoneNo,relativePhoneNo,natureOfJob,preDisease,admittedOn,travelHistory,contactWithCases,presentStatus,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, patient.getFirstName());
		ps.setString(2,patient.getLastName());
		ps.setInt(3,patient.getAge());
		ps.setString(4,patient.getGender());
		ps.setString(5,patient.getAddress());
		ps.setString(6,patient.getRegion());
		ps.setString(7,patient.getCountry());
		ps.setLong(8,patient.getPhoneNo());
		ps.setLong(9,patient.getRelativePhoneNo());
		ps.setString(10,patient.getNatureOfJob());
		ps.setString(11,patient.getPreDisease());
		ps.setString(12,patient.getAdmittedOn());
		ps.setString(13,patient.getTravelHistory());
		ps.setString(14,patient.getContactWithCases());
		ps.setString(15,patient.getPresentStatus());
		ps.setString(16,patient.getStatus());
		int result = ps.executeUpdate();
		System.out.println("new patient");
		ConnectionUtil.closeConnection(ps, conn);
		return result;
	}

	public static ArrayList<Patient> listAllPatients() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String status = "active";

		String sql = "SELECT * FROM patients where status=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		rs = ps.executeQuery();

		ArrayList<Patient> patientList = new ArrayList<Patient>();
		while (rs.next()) {
			Patient patient = new Patient();
			patient.setPatientId(rs.getInt(1));
			patient.setFirstName(rs.getString(2));
			patient.setLastName(rs.getString(3));
			patient.setAge(rs.getInt(4));
			patient.setGender(rs.getString(5));
			patient.setAddress(rs.getString(6));
			patient.setRegion(rs.getString(7));
			patient.setCountry(rs.getString(8));
			patient.setPhoneNo(rs.getLong(9));
			patient.setRelativePhoneNo(rs.getLong(10));
			patient.setNatureOfJob(rs.getString(11));
			patient.setPreDisease(rs.getString(12));
			//patient.setAdmittedOn(rs.getString(5));
			patient.setTravelHistory(rs.getString(14));
			patient.setContactWithCases(rs.getString(15));
			patient.setPresentStatus(rs.getString(16));

			patientList.add(patient);
			
		}
		return patientList;
	}

	public static ArrayList<CaseNumbers> findCaseNumbers() throws SQLException
	{

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;

		String sql=null;
		CaseNumbers caseNumbers = new CaseNumbers();
		ResultSet rs;
		ArrayList<CaseNumbers> tempCaseList = new ArrayList<CaseNumbers>();
		//Critical
		sql = "select count(*) from patients where presentStatus='Critical' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setCritical(rs.getInt(1));
		else
			caseNumbers.setCritical(0);

		//Cured
		sql = "select count(*) from patients where presentStatus='Recovered'and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setCured(rs.getInt(1));
		else
			caseNumbers.setCured(0);

		//deaths
		sql = "select count(*) from patients where presentStatus='Died' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setDeath(rs.getInt(1));
		else
			caseNumbers.setDeath(0);

		//Quarantined
		sql = "select count(*) from patients where presentStatus='Quarantined' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setQuarantined(rs.getInt(1));
		else
			caseNumbers.setQuarantined(0);

		//normal
		
		sql = "select count(*) from patients where presentStatus='Normal' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setNormal(rs.getInt(1));
		else
			caseNumbers.setNormal(0);



		//active
		caseNumbers.setActive(caseNumbers.getNormal()+caseNumbers.getCritical());
		
		//active
				caseNumbers.setTotal(caseNumbers.getNormal()+caseNumbers.getCritical()+caseNumbers.getCured()+caseNumbers.getDeath());

		tempCaseList.add(caseNumbers);
		return tempCaseList;

	}

	public static int deletePatient(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE patients SET STATUS=? WHERE PATIENTID=?";
		ps = conn.prepareStatement(sql);

		String status = "InActive";
		ps.setString(1, status);
		ps.setInt(2, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static Patient findOne(int patientId) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// int status = 1;
		String sql = "SELECT * FROM patients WHERE patientId=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, patientId);

		rs = ps.executeQuery();
		Patient patient = new Patient();
		if (rs.next()) {

			patient.setPatientId(rs.getInt(1));
			patient.setFirstName(rs.getString(2));
			patient.setLastName(rs.getString(3));
			patient.setAge(rs.getInt(4));
			patient.setGender(rs.getString(5));
			patient.setAddress(rs.getString(6));
			patient.setRegion(rs.getString(7));
			patient.setCountry(rs.getString(8));
			patient.setPhoneNo(rs.getLong(9));
			patient.setRelativePhoneNo(rs.getLong(10));
			patient.setNatureOfJob(rs.getString(11));
			patient.setPreDisease(rs.getString(12));
			patient.setAdmittedOn(rs.getString(13));
			patient.setTravelHistory(rs.getString(14));
			patient.setContactWithCases(rs.getString(15));
			patient.setPresentStatus(rs.getString(16));
			System.out.println(patient.getAdmittedOn());

		}

		return patient;
	}

	public static int updatePatient(Patient patient, int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE patients SET firstName=?,lastName=?,age=?,gender=?,address=?,region=?,country=?,phoneNo=?,relativePhoneNo=?,natureOfJob=?,preDisease=?,admittedOn=?,travelHistory=?,contactWithCases=?,presentStatus=? WHERE patientId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, patient.getFirstName());
		ps.setString(2, patient.getLastName());
		ps.setInt(3, patient.getAge());
		ps.setString(4, patient.getGender());
		ps.setString(5, patient.getAddress());
		ps.setString(6, patient.getRegion());
		ps.setString(7, patient.getCountry());
		ps.setLong(8,patient.getPhoneNo());
		ps.setLong(9, patient.getRelativePhoneNo());
		ps.setString(10, patient.getNatureOfJob());
		ps.setString(11,patient.getPreDisease());
		ps.setString(12,patient.getAdmittedOn() );
		ps.setString(13, patient.getTravelHistory());
		ps.setString(14,patient.getContactWithCases() );
		ps.setString(15,patient.getPresentStatus());
		ps.setInt(16, id);
		int result = ps.executeUpdate();
		return result;
	}
}
