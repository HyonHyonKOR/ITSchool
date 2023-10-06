package com.beaver.oct061.main;

import com.beaver.http.client.BeaverHttpClient;

//Java 전세계적으로 많이 사용
//개발자 본인이 만들어 놓은 것들을 공유!
//   소스 자체를 공유 X, .jar파일 만들어서 공유하는 문화 O
//.jar 파일으 자동으로 관리해주는 시스템  : Maven
//Maven 중앙 저장소 : https://mvnrepository.com/

//Maven 중앙 저장소에 없는 것들 : 로컬 저장소를 활용하면 됨! 
//dbm,httpclient

//Maven 활용하면
//Maven 중앙 저장소에 저장되어 있는 .jar파일
//컴퓨터의 Maven 로컬 저장소: C:\\Users\i\.m2\repository
//===================================================
// Maven 로컬 저장소에 라이브러리 등록하기
//  프로젝트 우 클릭 후 - Configure  - Conver to Maven Project

//  프로젝트 우 클릭 후 - import - maven 검색
//       => install or deploy ~~ 클릭
//   Browse => 만든 보물 설정해서 넣기 => Group Id, Artifact Id 설정 
//       =>버전은 마음대로 =>  Packaging은 jar 파일

//   로컬 저장소에서 => 이 프로젝트로 가져오기
//    porm.xml => Dependencies 탭 클릭 => Add 버튼 클릭
//         => Artifact Id로 검색 -> 선택
//=======================================================
//   Maven Error
//       => 이클립스 종료 => 로컬 저장소 지우기 => 이클립스 재시작
//         =>  다운받을 거 다시 받기


public class MMain {
	BeaverHttpClient bhc;
	
}
