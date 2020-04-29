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
		

		String sql = "INSERT INTO patientinfo(firstName,middleName,lastName,dob,gender,email,phoneNo,address,zone,woreda,region,country,natureOfJob,preDisease,admittedOn,travelHistory,contactWithCases,presentStatus,ecfirstName,relationShip,ecAddress,ecPhoneNo,ecEmail,allergies,medications,operation1,doo1,operation2,doo2,operation3,doo3,familyHistory,smoke,pregnantRisk,symptoms,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, patient.getFirstName());
		ps.setString(2, patient.getMiddleName());
		ps.setString(3,patient.getLastName());
		ps.setString(4, patient.getDob());
		ps.setString(5,patient.getGender());
		ps.setString(6, patient.getEmail());
		ps.setLong(7, patient.getPhoneNo());
		ps.setString(8,patient.getAddress());
		ps.setString(9,patient.getZone());
		ps.setString(10,patient.getWoreda());
		ps.setString(11,patient.getRegion());
		ps.setString(12,patient.getCountry());
		ps.setString(13,patient.getNatureOfJob());
		ps.setString(14,patient.getPreDisease());
		ps.setString(15,patient.getAdmittedOn());
		ps.setString(16,patient.getTravelHistory());
		ps.setString(17,patient.getContactWithCases());
		ps.setString(18,patient.getPresentStatus());
		ps.setString(19, patient.getEcfirstName());
		ps.setString(20, patient.getRelationShip());
		ps.setString(21, patient.getEcAddress());
		ps.setLong(22,patient.getEcPhoneNo());
		ps.setString(23, patient.getEcEmail());
		ps.setString(24, patient.getAllergies());
		ps.setString(25, patient.getMedications());
		ps.setString(26, patient.getOperation1());
		ps.setString(27, patient.getDoo1());
		ps.setString(28, patient.getOperation2());
		ps.setString(29, patient.getDoo2());
		ps.setString(30, patient.getOperation3());
		ps.setString(31, patient.getDoo3());
		ps.setString(32, patient.getFamilyHistory());
		ps.setString(33, patient.getSmoke());
		ps.setString(34, patient.getPregnantRisk());
		ps.setString(35, patient.getSymptoms());
		ps.setString(36,patient.getStatus());
		
		
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

		String sql = "SELECT * FROM patientinfo where status=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		rs = ps.executeQuery();

		ArrayList<Patient> patientList = new ArrayList<Patient>();
		while (rs.next()) {
			Patient patient = new Patient();
			patient.setPatientId(rs.getInt(1));
			patient.setFirstName(rs.getString(2));
			patient.setMiddleName(rs.getString(3));
			patient.setLastName(rs.getString(4));
			patient.setDob(rs.getString(5));
			patient.setGender(rs.getString(6));
			patient.setEmail(rs.getString(7));
			patient.setPhoneNo(rs.getLong(8));
			patient.setAddress(rs.getString(9));
			patient.setZone(rs.getString(10));
			patient.setWoreda(rs.getString(11));
			patient.setRegion(rs.getString(12));
			patient.setCountry(rs.getString(13));
			patient.setNatureOfJob(rs.getString(14));
			patient.setPreDisease(rs.getString(15));
			patient.setAdmittedOn(rs.getString(16));
			patient.setTravelHistory(rs.getString(17));
			patient.setContactWithCases(rs.getString(18));
			patient.setPresentStatus(rs.getString(19));
			patient.setEcfirstName(rs.getString(20));
			patient.setRelationShip(rs.getString(21));
			patient.setEcAddress(rs.getString(22));
			patient.setEcPhoneNo(rs.getLong(23));
			patient.setEcEmail(rs.getString(24));
			patient.setAllergies(rs.getString(25));
			patient.setMedications(rs.getString(26));
			patient.setOperation1(rs.getString(27));
			patient.setDoo1(rs.getString(28));
			patient.setOperation2(rs.getString(29));
			patient.setDoo2(rs.getString(30));
			patient.setOperation3(rs.getString(31));
			patient.setDoo3(rs.getString(32));
			patient.setFamilyHistory(rs.getString(33));
			patient.setSmoke(rs.getString(34));
			patient.setPregnantRisk(rs.getString(35));
			patient.setSymptoms(rs.getString(36));
		
			
			
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
		sql = "select count(*) from patientinfo where presentStatus='Critical' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setCritical(rs.getInt(1));
		else
			caseNumbers.setCritical(0);

		//Cured
		sql = "select count(*) from patientinfo where presentStatus='Recovered'and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setCured(rs.getInt(1));
		else
			caseNumbers.setCured(0);

		//deaths
		sql = "select count(*) from patientinfo where presentStatus='Died' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setDeath(rs.getInt(1));
		else
			caseNumbers.setDeath(0);

		//Quarantined
		sql = "select count(*) from patientinfo where presentStatus='Quarantined' and status='Active'";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next())
			caseNumbers.setQuarantined(rs.getInt(1));
		else
			caseNumbers.setQuarantined(0);

		//normal
		
		sql = "select count(*) from patientinfo where presentStatus='Normal' and status='Active'";
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
		String sql = "UPDATE patientinfo SET STATUS=? WHERE PATIENTID=?";
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
		String sql = "SELECT * FROM patientinfo WHERE patientId=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, patientId);

		rs = ps.executeQuery();
		Patient patient = new Patient();
		if (rs.next()) {

			patient.setPatientId(rs.getInt(1));
			patient.setFirstName(rs.getString(2));
			patient.setMiddleName(rs.getString(3));
			patient.setLastName(rs.getString(4));
			patient.setDob(rs.getString(5));
			patient.setGender(rs.getString(6));
			patient.setEmail(rs.getString(7));
			patient.setPhoneNo(rs.getLong(8));
			patient.setAddress(rs.getString(9));
			patient.setZone(rs.getString(10));
			patient.setWoreda(rs.getString(11));
			patient.setRegion(rs.getString(12));
			patient.setCountry(rs.getString(13));
			patient.setNatureOfJob(rs.getString(14));
			patient.setPreDisease(rs.getString(15));
			patient.setAdmittedOn(rs.getString(16));
			patient.setTravelHistory(rs.getString(17));
			patient.setContactWithCases(rs.getString(18));
			patient.setPresentStatus(rs.getString(19));
			patient.setEcfirstName(rs.getString(20));
			patient.setRelationShip(rs.getString(21));
			patient.setEcAddress(rs.getString(22));
			patient.setEcPhoneNo(rs.getLong(23));
			patient.setEcEmail(rs.getString(24));
			patient.setAllergies(rs.getString(25));
			patient.setMedications(rs.getString(26));
			patient.setOperation1(rs.getString(27));
			patient.setDoo1(rs.getString(28));
			patient.setOperation2(rs.getString(29));
			patient.setDoo2(rs.getString(30));
			patient.setOperation3(rs.getString(31));
			patient.setDoo3(rs.getString(32));
			patient.setFamilyHistory(rs.getString(33));
			patient.setSmoke(rs.getString(34));
			patient.setPregnantRisk(rs.getString(35));
			patient.setSymptoms(rs.getString(36));

		}

		return patient;
	}

	public static int updatePatient(Patient patient, int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE patientinfo SET firstName=?,middleName=?,lastName=?,dob=?,gender=?,email=?,phoneNo=?,address=?,zone=?,woreda=?,region=?,country=?,natureOfJob=?,preDisease=?,admittedOn=?,travelHistory=?,contactWithCases=?,presentStatus=?,ecfirstName=?,relationShip=?,ecAddress=?,ecPhoneNo=?,ecEmail=?,allergies=?,medications=?,operation1=?,doo1=?,operation2=?,doo2=?,operation3=?,doo3=?,familyHistory=?,smoke=?,pregnantRisk=?,symptoms=? WHERE patientId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, patient.getFirstName());
		ps.setString(2, patient.getMiddleName());
		ps.setString(3,patient.getLastName());
		ps.setString(4, patient.getDob());
		ps.setString(5,patient.getGender());
		ps.setString(6, patient.getEmail());
		ps.setLong(7, patient.getPhoneNo());
		ps.setString(8,patient.getAddress());
		ps.setString(9,patient.getZone());
		ps.setString(10,patient.getWoreda());
		ps.setString(11,patient.getRegion());
		ps.setString(12,patient.getCountry());
		ps.setString(13,patient.getNatureOfJob());
		ps.setString(14,patient.getPreDisease());
		ps.setString(15,patient.getAdmittedOn());
		ps.setString(16,patient.getTravelHistory());
		ps.setString(17,patient.getContactWithCases());
		ps.setString(18,patient.getPresentStatus());
		ps.setString(19, patient.getEcfirstName());
		ps.setString(20, patient.getRelationShip());
		ps.setString(21, patient.getEcAddress());
		ps.setLong(22,patient.getEcPhoneNo());
		ps.setString(23, patient.getEcEmail());
		ps.setString(24, patient.getAllergies());
		ps.setString(25, patient.getMedications());
		ps.setString(26, patient.getOperation1());
		ps.setString(27, patient.getDoo1());
		ps.setString(28, patient.getOperation2());
		ps.setString(29, patient.getDoo2());
		ps.setString(30, patient.getOperation3());
		ps.setString(31, patient.getDoo3());
		ps.setString(32, patient.getFamilyHistory());
		ps.setString(33, patient.getSmoke());
		ps.setString(34, patient.getPregnantRisk());
		ps.setString(35, patient.getSymptoms());
		ps.setInt(36, id);
		int result = ps.executeUpdate();
		return result;
	}

	public static ArrayList<Patient> listPatientsByStatus(String healthStatus) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String status = "active";

		String sql = "SELECT * FROM patientinfo where status=? and presentStatus=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		ps.setString(2, healthStatus);
		rs = ps.executeQuery();

		ArrayList<Patient> patientList = new ArrayList<Patient>();
		while (rs.next()) {
			Patient patient = new Patient();
			patient.setPatientId(rs.getInt(1));
			patient.setFirstName(rs.getString(2));
			patient.setMiddleName(rs.getString(3));
			patient.setLastName(rs.getString(4));
			patient.setDob(rs.getString(5));
			patient.setGender(rs.getString(6));
			patient.setEmail(rs.getString(7));
			patient.setPhoneNo(rs.getLong(8));
			patient.setAddress(rs.getString(9));
			patient.setZone(rs.getString(10));
			patient.setWoreda(rs.getString(11));
			patient.setRegion(rs.getString(12));
			patient.setCountry(rs.getString(13));
			patient.setNatureOfJob(rs.getString(14));
			patient.setPreDisease(rs.getString(15));
			patient.setAdmittedOn(rs.getString(16));
			patient.setTravelHistory(rs.getString(17));
			patient.setContactWithCases(rs.getString(18));
			patient.setPresentStatus(rs.getString(19));
			patient.setEcfirstName(rs.getString(20));
			patient.setRelationShip(rs.getString(21));
			patient.setEcAddress(rs.getString(22));
			patient.setEcPhoneNo(rs.getLong(23));
			patient.setEcEmail(rs.getString(24));
			patient.setAllergies(rs.getString(25));
			patient.setMedications(rs.getString(26));
			patient.setOperation1(rs.getString(27));
			patient.setDoo1(rs.getString(28));
			patient.setOperation2(rs.getString(29));
			patient.setDoo2(rs.getString(30));
			patient.setOperation3(rs.getString(31));
			patient.setDoo3(rs.getString(32));
			patient.setFamilyHistory(rs.getString(33));
			patient.setSmoke(rs.getString(34));
			patient.setPregnantRisk(rs.getString(35));
			patient.setSymptoms(rs.getString(36));
		
			
			
			patientList.add(patient);
			
		}
		return patientList;
	}
}
