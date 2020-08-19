package day25.ch02_map;

import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;



public class Quiz01 {
	public static void main(String[] args) {
		//키 : 영단어(String)
		//값 : 그의 뜻(String)
		
		//메뉴 : 
		//1.단어등록
		//2.단어 검색 -> 영단어 입력 받고 있으면 뜻을 출력, 없으면 "미등록 단어입니다."
		//3.모든 단어 보기 -> 모든 단어와 뜻을 출력
		//4.Quiz풀기 *** 선택문제 -> 랜덤하게 뜻을 출력 하고 영단어를 입력 받아서 "정답!" 혹은 "땡" 출력
		//0.종료
		
		String menu = "1. 단어등록 \n 2.단어검색 \n 3.모든 단어 보기\n 4.Quiz 풀기 \n 0.종료";
		
		HashMap<String, String> voca = new HashMap<>();
		while(true) {
			String select =  JOptionPane.showInputDialog(menu);
			switch (select) {
			case "1":
				voca.put(JOptionPane.showInputDialog("등록 할 단어 입력"), JOptionPane.showInputDialog("단어의 뜻을 입력"));		
				break;
			case "2":
				String k =JOptionPane.showInputDialog("검색할 단어 입력");
				if(voca.containsKey(k)) {
					JOptionPane.showMessageDialog(null, "단어의 뜻 : "+ voca.get(k));
				}
				else {
					JOptionPane.showMessageDialog(null, "미등록 단어입니다.");
				}
				break;
			case "3":
				StringBuffer sb = new StringBuffer("-----------단어 리스트 -----------\n");
				Set<String> key =  voca.keySet();
				
				for(String e : key) {
					sb.append(e+":"+voca.get(e)+"\n");
			
				}

				JOptionPane.showMessageDialog(null, sb);
				break;
				
			case "4":
				//4.Quiz풀기 *** 선택문제 -> 랜덤하게 뜻을 출력 하고 영단어를 입력 받아서 "정답!" 혹은 "땡" 출력
				int rand = (int)(Math.random()*voca.size())+1;//1~voca.size()
				int num = rand%voca.size();
		
				Object[] keys = voca.keySet().toArray();

				String answer = JOptionPane.showInputDialog(keys[num]);
				
				if(answer.equals(voca.get(keys[num]))) {
					JOptionPane.showMessageDialog(null, "정답!");
				}
				else {
					JOptionPane.showMessageDialog(null, "땡!");
				}
				// Object[] keys1 = voca.values().toArray();
				// System.out.println(keys1[num]);
				break;
			case "0":
				return;

			}
		}
	}
}
