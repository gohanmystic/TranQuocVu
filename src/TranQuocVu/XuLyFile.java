package TranQuocVu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XuLyFile {
	public void DocFileInput() {
		try {
			FileInputStream FIS = new FileInputStream("input.txt");
			InputStreamReader ISR = new InputStreamReader(FIS);
			BufferedReader BRInput = new BufferedReader(ISR);
			
			while (true) {
				String st = BRInput.readLine();
				if(st == "" || st == null || st.isEmpty()) break;
				//System.out.println(st);
				String[] ds = st.split("[,]");
				System.out.println(ds[0]+ds[1]+ds[2]+ds[3]+ds[4]+ds[5]+ds[6]+ds[7]+ds[8]+ds[9]);
			}
			BRInput.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	public boolean CheckNgaySinh (String ngaysinh) {
		try {
			String day = ngaysinh.replace('/', '-');
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date date = format.parse(day);
			String dayCheck = "00:00:00 " + day;
			if(dayCheck.compareTo(date.toLocaleString()) != 0){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean CheckSDT (String sodienthoai) {
		try{
			if (sodienthoai.length() < 7) {
				return false;
			}else {				
				Integer sdt = Integer.parseInt(sodienthoai);			
				return true;
			}
		}catch(Exception e){
			return false;
		}		
	}
	
	public boolean CheckEmail (String email) {
		int demAcong = 0;
		int demCham = 0;
		for (int i = 0; i < email.length(); i++){
			if(email.charAt(i) == '@') demAcong++;
			if(email.charAt(i) == '.') demCham++;
		}
		
		if(demAcong == 1 && demCham >0){
			return true;
		}else{
			return false;
		}
	}

	public boolean CheckSoNamKN(String sonamkn){
		if(sonamkn.equalsIgnoreCase("none")) return true;
		
		int SoNamKinhNghiem = Integer.parseInt(sonamkn);		
		if(SoNamKinhNghiem > 0 && SoNamKinhNghiem < 100) return true;
		
		return false;
	}
	
	public boolean CheckDongDuLieu(String[] dulieu){
		if(dulieu.length > 10) return false;
		return true;
	}
	public void ThongTinHopLe() {
		int i = 1;
		try {
			//doc file input.txt
			FileInputStream FIS = new FileInputStream("input.txt");
			InputStreamReader ISR = new InputStreamReader(FIS);
			BufferedReader BRInput = new BufferedReader(ISR);
			
			//ghi file output.txt
			FileOutputStream FOS = new FileOutputStream("output.txt");
			OutputStreamWriter OSW = new OutputStreamWriter(FOS);
			PrintWriter PWoutput = new PrintWriter(OSW);
			while (true) {
				String st = BRInput.readLine();
				if(st == "" || st == null || st.isEmpty()) break;
				String[] ds = st.split("[,]");
				if (CheckNgaySinh(ds[2].trim()) && CheckSDT(ds[5].trim()) && CheckEmail(ds[6].trim()) && CheckSoNamKN(ds[7].trim()) && CheckDongDuLieu(ds)) {
					System.out.println(ds[0]+ds[1]+ds[2]+ds[3]+ds[4]+ds[5]+ds[6]+ds[7]+ds[8]+ds[9]);
				}else{
					System.out.print(i+","); PWoutput.print(i+",");
					if(CheckNgaySinh(ds[2].trim())){System.out.print(","); PWoutput.print(",");} else if(!CheckNgaySinh(ds[2].trim())) {System.out.print("Yes"); PWoutput.print("Yes");}
					if(CheckSDT(ds[5].trim())){System.out.print(","); PWoutput.print(",");} else if(!CheckSDT(ds[5].trim())) {System.out.print("Yes"); PWoutput.print("Yes");}
					if(CheckEmail(ds[6].trim())){System.out.print(","); PWoutput.print(",");} else if(!CheckEmail(ds[6].trim())) {System.out.print("Yes"); PWoutput.print("Yes");}
					if(CheckSoNamKN(ds[7].trim())){System.out.print(","); PWoutput.print(",");} else if(!CheckSoNamKN(ds[7].trim())) {System.out.print("Yes"); PWoutput.print("Yes");}
					if(CheckDongDuLieu(ds)){System.out.println(","); PWoutput.println(",");} else if(!CheckDongDuLieu(ds)) {System.out.println("Yes"); PWoutput.println("Yes");}
					
					
				}
				i++;
			}
			PWoutput.close();
			BRInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
