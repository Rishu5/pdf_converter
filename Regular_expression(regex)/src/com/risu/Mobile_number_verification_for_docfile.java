package com.risu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile_number_verification_for_docfile {
	public static void main(String[] args) throws Exception {
		String str = "C:/Users/Rishu Kumar/Desktop/rishu";
		
		File f = new File(str + File.separator + "moblile_number.txt");
		f.createNewFile();
		PrintWriter pw = new PrintWriter(new FileWriter(f, false));
		pw.println("8051820665");
		pw.println("9570444204");
		pw.println("9631820665");
		pw.println("7546024217");
		pw.println("9661612262");
		pw.println("8853019151");
		pw.println("rhnsk68564sdj466d2@");
		pw.println("8051820sf34sdfjhsadklj;lsadfmsadgsdfg");
		pw.println("hi my nae is rishu kuamr gupta bhawnmio pur bazar 9570444204");
		pw.println("bhaiya teliphone number si = 9631820665");
		pw.println("7546024217 sumit kuamr lohsanbsflkjkl sdfj");
		pw.println("buffer ridr jk;lk;ljfk;ldjk;lsadfmn sdlfkjkl 9825654640 9661612262");
		pw.println("8853019151");
		pw.println("jlhvb,. jhg vuyjutluihklui vkljh , rhnsk68564sdj466d2@");
		pw.println("8051820sf3463 6388439820  9572122949 , 8579015912 lkjhwerk;ljhnk;lsh, 8051820665 8266463463463654354352 ");
		pw.flush();
		pw.close();
		
		///////////////////////////////////////////
		
		Pattern p = Pattern.compile("(0|91)?[5-9][0-9]{9}");// ye mobile number verification ke liye likha gya h regular experatuin 
		File f1 = new File(str + File.separator + "moblile_number1.txt");
		f1.createNewFile();
		PrintWriter pw1 = new PrintWriter(new FileWriter(f1));
		BufferedReader br = new BufferedReader(new FileReader(f));
		String str1 = br.readLine();
		while (str1 != null) {
			Matcher m = p.matcher(str1);
			while (m.find()) {
				pw1.println(m.group());
			}
			str1 = br.readLine();
		}
		pw1.flush();
		br.close();
		pw1.close();
		

	}

}
