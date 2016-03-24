<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div class="container" style="width:1000px; margin:0 auto;">
	<div class="row display-table">
	    <div class="col-xs-12 col-sm-4 display-cell" >
		    <ul class="nav nav-pills nav-stacked">
		    	<li class="dropdown active"><a onclick="opr.sysout()">배열출력</a></li>
		    	<li class="dropdown active"><a onclick="opr.score()">어벤저스</a>	</li>
		    	<li class="dropdown active"><a onclick="opr.grade()">성적계산기</a></li>
		    	<li class="dropdown active"><a onclick="opr.gender()">성별 구분하기</a></li>
		    	<li class="dropdown active"><a onclick="opr.bigNum()">최대수 판별</a></li>
		    	<li class="dropdown active"><a onclick="opr.gugudan()">구구단</a></li>
		    	<li class="dropdown active"><a onclick="opr.sum1to100()">1부터 100까지 합</a></li>
		    	<li class="dropdown active"><a onclick="opr.oddSum()">짝수합, 홀수합</a></li>
		    </ul>
	    </div>
	    <div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px">
	        OPERATOR 시작!
	    </div>
	</div>
</div>
<script type="text/javascript">
var opr = {
	sysout : function(){
		var arr = ['사과', '배', '감', '귤'];
		var result = '';
		for ( var i in arr) {
			console.log(arr[i] + '\t');
			result += arr[i] + '\t';
		}
		
		document.getElementById("result").innerHTML = result;
	},
	
	score : function(){
		var result = '';
		var avengers = [];
		
		avengers.push({name : '아이언맨', kor : 92, eng : 92, math : 92});
		avengers.push({name : '헐크', kor : 80, eng : 80, math : 80});
		avengers.push({name : '캡틴', kor : 70, eng : 75, math : 77});
		
		for ( var i in avengers) {
			avengers[i].getSum = function() {
				return this.kor + this.eng + this.math;
			}
			avengers[i].getAvg = function() {
				return this.getSum()/3;
			}
			
			console.log(avengers[i].name + '님의 점수합계는 ' + avengers[i].getSum() 
							+ '점이고 평균은 ' + avengers[i].getAvg() + '점입니다.');
		}
		
		result  = '============ 어벤져스 성적표 ============<br/>';
		result += '이름\t 국어\t 영어\t 수학\t 총점\t 평균<br/>';
		result += '--------------------------------------<br/>';
		
		for ( var i in avengers) {
			{
				with(avengers[i]){
					result += name + ':\t' + kor + '\t' + eng + '\t' + math + '\t' + getSum() + '\t' + getAvg() + '<br/>';
				}
			}
		}
		/*
			with 키워드는 배열에 담긴 하나의 객체를 의미한다.
			즉 예를 들어
			var iron = {name : '아이언맨', kor : 92, eng : 92, math : 92}
			이렇게 선언된 하나의 객체를 avengers.push(iron)이라고 줄 경우
			출력문에서 with를 사용하지 않는다면 iron.name 이런 식으로 일일히
			명시해야 하기 때문에 with를 사용한다.
		*/
		
		console.log(result);
		
		document.getElementById("result").innerHTML = result;
	},
	
	grade : function() {
		/* 
			90 이상 A
			80 이상 B
			70 이상 C
			60 이상 D
			60 미만 F
		*/
		var kor = Number(prompt('국어점수')),
			eng = Number(prompt('영어점수')),
			math = Number(prompt('수학점수'));
		var sum = kor + eng + math;
		var avg = sum/3;
		var result = '';
		
		if (avg >= 90) {
			result = 'A';
		} else if (avg >= 80) {
			result = 'B';
		} else if (avg >= 70) {
			result = 'C';
		} else if (avg >= 60) {
			result = 'D';
		} else if (avg < 60) {
			result = 'F';
		}
		
		console.log(sum);
		console.log(avg);
		console.log(result);
		
		document.getElementById("result").innerHTML = "점수합계: " + (kor+eng+math) + " 점수평균: " + ((kor+eng+math)/3) + " 학점: " + result;
	},
	
	gender : function() {
		/* 
		800101-1234567 일 경우 flag 값은 1 이다라고 정의함
		*/
		var flag = 4; // 라면 성별을 판별하는 로직을 switch - case 로 완성하시오. 자바의 switch case 와 동일
		var result = '';
		
		switch (flag) {
		case 1: case 3:
			result = '남자';
			break;
		case 2: case 4:
			result = '여자';
			break;

		default:
			result = '잘 못 입력';
			break;
		}
		console.log(result);
		document.getElementById("result").innerHTML = result;
	},
	
	bigNum : function() {
		/* 80, 70, 60 일 경우 if 문으로 최대값 을 구하는 로직을 완성하시오 */
		
		var a = 80, b = 70, c = 60;
		var result = 0;
		
		if(a>b || a>c) {
			result = a;
		} else if(b>c) {
			result = b;
		} else {
			result = c;
		}
		
		console.log(result);
		document.getElementById("result").innerHTML = result;
	},
	
	gugudan : function() {
		var i = 1, j = Number(prompt('단 입력')), dan = 0;
		var result = '';
		for (var int = i; i < 10; i++) {
			// 7단 구구단을 출력하시오
			console.log(j +' * ' + i + ' = ' + (j * i));
			result += j + ' * ' + i + ' = ' + (j * i) + '<br/>';
		}
		document.getElementById("result").innerHTML = result;
	},
	
	sum1to100 : function() {
		var sum = 0, i = 0;
		while (i<101) {
			/* 1부터 100까지의 합을 출력하시오*/
			sum += i;
			i++;
		}
		console.log(sum);
		document.getElementById("result").innerHTML = sum;
	},
	
	oddSum : function() {
		var oddSum = 0,evenSum = 0;
		for (var i = 0; i < 100; i++) {
			// 1부터 100 까지 수 중에서 홀수의 합 oddSum 과 
			// 짝수들의 합 evenSum 을 구하시오
			if ((i%2) == 0) {
				evenSum += i;
			} else if ((i%2) == 1) {
				oddSum += i;
			}
		}
		
		console.log('짝수합: ' + evenSum + '  홀수합: '+ oddSum);
		document.getElementById("result").innerHTML = '짝수합: ' + evenSum + '  홀수합: '+ oddSum;
	}
}

</script>