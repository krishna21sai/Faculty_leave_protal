package operations;
import java.sql.Connection;

import java.sql.Statement;

import model.DataManager;
public class batch {
	Connection c=null;
	Statement st=null;
	boolean b=false;
	public boolean createAeps(DataManager db,String batch)
	{
		try
		{
		
			String query="create database aeps"+batch;
			System.out.println(query);
			b=db.operation(query,"Create");
			//System.out.println(batch);
			//System.out.println(b);
			if(b)
			{
	
				String attendance_1_1="CREATE TABLE  `aeps"+batch+"`.`attendance_1_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_1_2="CREATE TABLE  `aeps"+batch+"`.`attendance_1_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_2_1="CREATE TABLE  `aeps"+batch+"`.`attendance_2_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_2_2="CREATE TABLE  `aeps"+batch+"`.`attendance_2_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_3_1="CREATE TABLE  `aeps"+batch+"`.`attendance_3_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_3_2="CREATE TABLE  `aeps"+batch+"`.`attendance_3_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_4_1="CREATE TABLE  `aeps"+batch+"`.`attendance_4_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String attendance_4_2="CREATE TABLE  `aeps"+batch+"`.`attendance_4_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`att_month` varchar(15) default NULL,"+
						  "`att_year` varchar(15) default NULL,"+
						  "`att_percent` int(11) default NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String career_development_1_1="CREATE TABLE  `aeps"+batch+"`.`career_develop_1_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_1_2="CREATE TABLE  `aeps"+batch+"`.`career_develop_1_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_2_1="CREATE TABLE  `aeps"+batch+"`.`career_develop_2_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_2_2="CREATE TABLE  `aeps"+batch+"`.`career_develop_2_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_3_1="CREATE TABLE  `aeps"+batch+"`.`career_develop_3_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_3_2="CREATE TABLE  `aeps"+batch+"`.`career_develop_3_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_4_1="CREATE TABLE  `aeps"+batch+"`.`career_develop_4_1` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String career_development_4_2="CREATE TABLE  `aeps"+batch+"`.`career_develop_4_2` ("+
						  "`registerno` varchar(11) default NULL,"+
						  "`programs` varchar(100) default NULL,"+
						  "`program_type` varchar(50) default NULL,"+
						  "`timings` varchar(50) default NULL,"+
						  "`hours_week` int(11) default NULL,"+
						  "`study_or_job` varchar(45) NOT NULL,"+
						  "KEY `registerno` (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				String counselling_1_1="CREATE TABLE  `aeps"+batch+"`.`counselling_1_1`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String counselling_1_2="CREATE TABLE  `aeps"+batch+"`.`counselling_1_2`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				
				String counselling_2_1="CREATE TABLE  `aeps"+batch+"`.`counselling_2_1`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				
				String counselling_2_2="CREATE TABLE  `aeps"+batch+"`.`counselling_2_2`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String counselling_3_1="CREATE TABLE  `aeps"+batch+"`.`counselling_3_1`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String counselling_3_2="CREATE TABLE  `aeps"+batch+"`.`counselling_3_2`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String counselling_4_1="CREATE TABLE  `aeps"+batch+"`.`counselling_4_1`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String counselling_4_2="CREATE TABLE  `aeps"+batch+"`.`counselling_4_2`("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`counselling_week` int(11) NOT NULL default '0',"+
						  "`title` varchar(50) default NULL,"+
						  "`problems` varchar(255) default NULL,"+
						  "`suggestions` varchar(255) default NULL,"+
						  "`date` date NOT NULL,"+
						 "PRIMARY KEY  USING BTREE (`registerno`,`counselling_week`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
				
				String parent_observation_1_1="CREATE TABLE  `aeps"+batch+"`.`parent_observation_1_1` ("+
								  "`registerno` varchar(11) NOT NULL,"+
								  "`beh_elders` varchar(15) default NULL,"+
								  "`beh_friends` varchar(15) default NULL,"+
								  "`beh_working` varchar(15) default NULL,"+
								  "`health` varchar(15) default NULL,"+
								  "`confidence_level` varchar(15) default NULL,"+
								  "`comm_skills` varchar(15) default NULL,"+
								  "PRIMARY KEY  (`registerno`),"+
								  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			
				
				String parent_observation_1_2="CREATE TABLE  `aeps"+batch+"`.`parent_observation_1_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			

				String parent_observation_2_1="CREATE TABLE  `aeps"+batch+"`.`parent_observation_2_1` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			

				String parent_observation_2_2="CREATE TABLE  `aeps"+batch+"`.`parent_observation_2_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			

				String parent_observation_3_1="CREATE TABLE  `aeps"+batch+"`.`parent_observation_3_1` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			

				String parent_observation_3_2="CREATE TABLE  `aeps"+batch+"`.`parent_observation_3_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			

				String parent_observation_4_1="CREATE TABLE  `aeps"+batch+"`.`parent_observation_4_1` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			

				String parent_observation_4_2="CREATE TABLE  `aeps"+batch+"`.`parent_observation_4_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`beh_elders` varchar(15) default NULL,"+
						  "`beh_friends` varchar(15) default NULL,"+
						  "`beh_working` varchar(15) default NULL,"+
						  "`health` varchar(15) default NULL,"+
						  "`confidence_level` varchar(15) default NULL,"+
						  "`comm_skills` varchar(15) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";			
				
				
			    String student_selfanalysis_1_1="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_1_1` ("+
								  "`registerno` varchar(11) NOT NULL,"+
								  "`com_english` int(11) default NULL,"+
								  "`com_mothertongue` int(11) default NULL,"+
								  "`com_general` int(11) default NULL,"+
								  "`com_confidence` int(11) default NULL,"+
								  "`aca_motivation_eng` int(11) default NULL,"+
								  "`aca_motivation_gen` int(11) default NULL,"+
								  "`aca_pastperformance` int(11) default NULL,"+
								  "`aca_expectedperf` int(11) default NULL,"+
								  "`hw_theory` int(11) default NULL,"+
								  "`hw_problem` int(11) default NULL,"+
								  "`sm_studies` int(11) default NULL,"+
								  "`sm_career` int(11) default NULL,"+
								  "`hlth_blodgroup` varchar(10) default NULL,"+
								  "`hlth_weight` decimal(10,2) default NULL,"+
								  "`hlth_height` decimal(10,2) default NULL,"+
								  "`hlth_chest` decimal(10,2) default NULL,"+
								   "`hlth_eyesight` varchar(10) default NULL,"+
								  "`chronic_diseases` varchar(1000) default NULL,"+
								  "`emergency_essentials` varchar(1000) default NULL,"+
								  "PRIMARY KEY  (`registerno`),"+
								  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
			
			    String student_selfanalysis_1_2="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_1_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			    String student_selfanalysis_2_1="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_2_1` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			    String student_selfanalysis_2_2="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_2_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			    String student_selfanalysis_3_1="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_3_1` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			    String student_selfanalysis_3_2="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_3_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			    String student_selfanalysis_4_1="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_4_1` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			    String student_selfanalysis_4_2="CREATE TABLE  `aeps"+batch+"`.`student_selfanalysis_4_2` ("+
						  "`registerno` varchar(11) NOT NULL,"+
						  "`com_english` int(11) default NULL,"+
						  "`com_mothertongue` int(11) default NULL,"+
						  "`com_general` int(11) default NULL,"+
						  "`com_confidence` int(11) default NULL,"+
						  "`aca_motivation_eng` int(11) default NULL,"+
						  "`aca_motivation_gen` int(11) default NULL,"+
						  "`aca_pastperformance` int(11) default NULL,"+
						  "`aca_expectedperf` int(11) default NULL,"+
						  "`hw_theory` int(11) default NULL,"+
						  "`hw_problem` int(11) default NULL,"+
						  "`sm_studies` int(11) default NULL,"+
						  "`sm_career` int(11) default NULL,"+
						  "`hlth_blodgroup` varchar(10) default NULL,"+
						  "`hlth_weight` decimal(10,2) default NULL,"+
						  "`hlth_height` decimal(10,2) default NULL,"+
						  "`hlth_chest` decimal(10,2) default NULL,"+
						   "`hlth_eyesight` varchar(10) default NULL,"+
						  "`chronic_diseases` varchar(1000) default NULL,"+
						  "`emergency_essentials` varchar(1000) default NULL,"+
						  "PRIMARY KEY  (`registerno`),"+
						  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_1_1="CREATE TABLE  `aeps"+batch+"`.`student_details_1_1` ("+
							  "`registerno` varchar(11) NOT NULL,"+
							  "`living_style` varchar(20) default NULL,"+
							  "`friend_registerno` varchar(12) default NULL,"+
							  "`friend_name` varchar(100) default NULL,"+
							  "`friend_contact` varchar(100) default NULL,"+
							  "`friend_branch` varchar(20) default NULL,"+
							  "`friend_college` varchar(100) default NULL,"+
							  "`friend_email` varchar(100) default NULL,"+
							  "`hostel_roomno` varchar(15) default NULL,"+
							  "`doorno` varchar(50) default NULL,"+
							  "`street` varchar(50) default NULL,"+
							  "`town` varchar(50) default NULL,"+
							  "`district` varchar(50) default NULL,"+
							  "`state` varchar(50) default NULL,"+
							  "`pin` varchar(10) default NULL,"+
							  "`communication_skills` int(11) default NULL,"+
							  "`beh_with_others` int(11) default NULL,"+
							  "`teamspirit` int(11) default NULL,"+
							  "`creativity` int(11) default NULL,"+
							  "`leadeship` int(11) default NULL,"+
							  "`negative_thinking` int(11) default NULL,"+
							  "`regularity` int(11) default NULL,"+
							  "`dresscode` int(11) default NULL,"+
							  "`general_aptitude` int(11) default NULL,"+
							  "`beh_aggressive` int(11) default NULL,"+
							  "`beh_dull` int(11) default NULL,"+
							  "`extrovert` int(11) default NULL,"+
							  "`introvert` int(11) default NULL,"+
							  "`lang_class_teacher` int(11) default NULL,"+
							  "`lang_outside_teacher` int(11) default NULL,"+
							  "`lang_campus_friends` int(11) default NULL,"+
							  "`beh_class` int(11) default NULL,"+
							  "`beh_outside` int(11) default NULL,"+
							  "`beh_out_campus` int(11) default NULL,"+
							  "`beh_opposite_gen` varchar(20) default NULL,"+
							  "`group_attitude` varchar(20) default NULL,"+
							  "`abnormal_beh` varchar(250) default NULL,"+
							 " `counsellor_report` varchar(1000) default NULL,"+
							 "`counsellor_suggestions` varchar(1000) default NULL,"+
							 "`sem_student_rating` int(11) default NULL,"+
							 "`sem_counsellor_rating` int(11) default NULL,"+
							 "`url` varchar(1000) default NULL,"+
							 "`academic_development` varchar(1000) default NULL,"+
							 "`health_height` varchar(45) default NULL,"+
							 "`health_weight` varchar(45) default NULL,"+
							 "`health_eyesight` varchar(45) default NULL,"+
							 "`health_abnormal` varchar(50) default NULL,"+
							 "`health_report` varchar(500) default NULL,"+
							 " PRIMARY KEY  (`registerno`),"+
							 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
					
			String student_details_1_2="CREATE TABLE  `aeps"+batch+"`.`student_details_1_2` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_2_1="CREATE TABLE  `aeps"+batch+"`.`student_details_2_1` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_2_2="CREATE TABLE  `aeps"+batch+"`.`student_details_2_2` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_3_1="CREATE TABLE  `aeps"+batch+"`.`student_details_3_1` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_3_2="CREATE TABLE  `aeps"+batch+"`.`student_details_3_2` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_4_1="CREATE TABLE  `aeps"+batch+"`.`student_details_4_1` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_details_4_2="CREATE TABLE  `aeps"+batch+"`.`student_details_4_2` ("+
					  "`registerno` varchar(11) NOT NULL,"+
					  "`living_style` varchar(20) default NULL,"+
					  "`friend_registerno` varchar(12) default NULL,"+
					  "`friend_name` varchar(100) default NULL,"+
					  "`friend_contact` varchar(100) default NULL,"+
					  "`friend_branch` varchar(20) default NULL,"+
					  "`friend_college` varchar(100) default NULL,"+
					  "`friend_email` varchar(100) default NULL,"+
					  "`hostel_roomno` varchar(15) default NULL,"+
					  "`doorno` varchar(50) default NULL,"+
					  "`street` varchar(50) default NULL,"+
					  "`town` varchar(50) default NULL,"+
					  "`district` varchar(50) default NULL,"+
					  "`state` varchar(50) default NULL,"+
					  "`pin` varchar(10) default NULL,"+
					  "`communication_skills` int(11) default NULL,"+
					  "`beh_with_others` int(11) default NULL,"+
					  "`teamspirit` int(11) default NULL,"+
					  "`creativity` int(11) default NULL,"+
					  "`leadeship` int(11) default NULL,"+
					  "`negative_thinking` int(11) default NULL,"+
					  "`regularity` int(11) default NULL,"+
					  "`dresscode` int(11) default NULL,"+
					  "`general_aptitude` int(11) default NULL,"+
					  "`beh_aggressive` int(11) default NULL,"+
					  "`beh_dull` int(11) default NULL,"+
					  "`extrovert` int(11) default NULL,"+
					  "`introvert` int(11) default NULL,"+
					  "`lang_class_teacher` int(11) default NULL,"+
					  "`lang_outside_teacher` int(11) default NULL,"+
					  "`lang_campus_friends` int(11) default NULL,"+
					  "`beh_class` int(11) default NULL,"+
					  "`beh_outside` int(11) default NULL,"+
					  "`beh_out_campus` int(11) default NULL,"+
					  "`beh_opposite_gen` varchar(20) default NULL,"+
					  "`group_attitude` varchar(20) default NULL,"+
					  "`abnormal_beh` varchar(250) default NULL,"+
					 " `counsellor_report` varchar(1000) default NULL,"+
					 "`counsellor_suggestions` varchar(1000) default NULL,"+
					 "`sem_student_rating` int(11) default NULL,"+
					 "`sem_counsellor_rating` int(11) default NULL,"+
					 "`url` varchar(1000) default NULL,"+
					 "`academic_development` varchar(1000) default NULL,"+
					 "`health_height` varchar(45) default NULL,"+
					 "`health_weight` varchar(45) default NULL,"+
					 "`health_eyesight` varchar(45) default NULL,"+
					 "`health_abnormal` varchar(50) default NULL,"+
					 "`health_report` varchar(500) default NULL,"+
					 " PRIMARY KEY  (`registerno`),"+
					 " FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";

			String student_events="CREATE TABLE  `aeps"+batch+"`.`student_events`("+
							  "`registerno` varchar(11) NOT NULL default '',"+
							  "`event_name` varchar(50) NOT NULL default '',"+
							  "`event_date` date NOT NULL default '0000-00-00',"+
							  "`fest_name` varchar(50) default NULL,"+
							  "`college_name` varchar(50) default NULL,"+
							  "`college_loc` varchar(50) default NULL,"+
							  "`prize` varchar(50) default NULL,"+
							  "`prize_year` varchar(20) default NULL,"+
							  "`sem` varchar(20) default NULL,"+
							  "PRIMARY KEY  (`registerno`,`event_name`,`event_date`),"+
							  "FOREIGN KEY (`registerno`) REFERENCES `student_master`.`student` (`registerno`))";
			
			
			boolean at=db.operation(attendance_1_1,"create");
			System.out.println("gfgfdg f   "+db.operation(attendance_1_2,"create"));
			db.operation(attendance_2_1,"create");
			db.operation(attendance_2_2,"create");
			db.operation(attendance_3_1,"create");
			db.operation(attendance_3_2,"create");
			db.operation(attendance_4_1,"create");
			db.operation(attendance_4_2,"create");
			
			boolean cd=db.operation(career_development_1_1,"create");
			db.operation(career_development_1_2,"create");
			db.operation(career_development_2_1,"create");
			db.operation(career_development_2_2,"create");
			db.operation(career_development_3_1,"create");
			db.operation(career_development_3_2,"create");
			db.operation(career_development_4_1,"create");
			db.operation(career_development_4_2,"create");
			
		boolean co=db.operation(counselling_1_1,"create");
			db.operation(counselling_1_2,"create");
			db.operation(counselling_2_1,"create");
			db.operation(counselling_2_2,"create");
			db.operation(counselling_3_1,"create");
			db.operation(counselling_3_2,"create");
			db.operation(counselling_4_1,"create");
			db.operation(counselling_4_2,"create");
			
			boolean po=db.operation(parent_observation_1_1,"create");
			db.operation(parent_observation_1_2,"create");
			
			db.operation(parent_observation_2_1,"create");
			db.operation(parent_observation_2_2,"create");
			db.operation(parent_observation_3_1,"create");
			db.operation(parent_observation_3_2,"create");
			db.operation(parent_observation_4_1,"create");
			db.operation(parent_observation_4_2,"create");
			
			
			boolean sa=db.operation(student_selfanalysis_1_1,"create");
			db.operation(student_selfanalysis_1_2,"create");
			db.operation(student_selfanalysis_2_1,"create");
			db.operation(student_selfanalysis_2_2,"create");
			db.operation(student_selfanalysis_3_1,"create");
			db.operation(student_selfanalysis_3_2,"create");
			db.operation(student_selfanalysis_4_1,"create");
			db.operation(student_selfanalysis_4_2,"create");
			
			boolean sd=db.operation(student_details_1_1,"create");
			db.operation(student_details_1_2,"create");
			db.operation(student_details_2_1,"create");
			db.operation(student_details_2_2,"create");
			db.operation(student_details_3_1,"create");
			db.operation(student_details_3_2,"create");
			db.operation(student_details_4_1,"create");
			db.operation(student_details_4_2,"create");
		
			
			boolean ev=db.operation(student_events,"create");
			if(at&&cd&&co&&po&&sa&&sd&&ev)
			 {
				System.out.println("Created tables Successfully");
				
				return true;
		    	}
			else
			{
				System.out.println(db.getErrorMessage());
				System.out.println("Created tables failed");
				return false;
			}
			
	
	
		}
			else
			{
				System.out.println("Database not created");

				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
		
	}
	
	

}
