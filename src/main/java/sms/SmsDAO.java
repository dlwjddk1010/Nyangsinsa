package sms;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsDAO {
	// 문자 전송 메서드
	public int sns(SmsVO svo) {

		int randomNum = (int) (Math.random() * (99999 - 10000 + 1)) + 10000; // 인증번호는 랜덤 숫자로 지정됨.

		String api_key = "NCSSQY674X4XMFAJ"; // 발급받은 api_key

		String api_secret = "HDZVQDOTUZ8IFBCWZQACLEDDG4HLITRN"; // 발급받은 api_secret

		Message coolsms = new Message(api_key, api_secret);
		

		HashMap<String, String> params = new HashMap<String, String>();

		params.put("to", svo.getMemberPhone()); // 수신번호(문자를 받을 사람)

		params.put("from", "0106585"); // 발신번호(문자를 보낼 사람)
//		01065851164
		params.put("type", "sms"); // 문자 타입
		params.put("text", "[냥신사] 본인인증번호는\n" + randomNum + " 입니다."); // 문자내용
		params.put("app_version", "test app 1.2");

		try {
			JSONObject obj = (JSONObject) coolsms.send(params); // 보내기&전송결과받기
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}

		return randomNum; // 인증번호 리턴

	}

}
