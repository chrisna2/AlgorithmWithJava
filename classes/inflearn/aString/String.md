# 인프런 : 자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비
## 섹션 1. String(문자열)

1. 문자 찾기 - ***FindString.java***
    - 문제 내용 : 문자열에서 특정 알파벳의 갯수를 파악하는 문제
    - POINT : 
    ```java 
    //String은 char의 배열이다.
        String a = "String equals Character Array";
        char[] array = a.toCharArray();

    //Java 익숙해 질 것 : java의 foreach
        for(char x: array){ }
    ```

2. 대소문자 변환 - ***SwitchCase.java***
    - 문제 내용 : 대문자 소문자 서로 변경
    - POINT : 
    ```java 
        char a = 'a';
    //Character의 하위 메서드
        Character.isUpperCase(a); // 대문자인가?
        Character.isLowerCase(a); // 소문자인가?
        Character.toUpperCase(a); // 대문자로
        Character.toLowerCase(a); // 소문자로
    ```

3. 문장 속 단어(indexOf(), substring()) - ***FindLongWord.java***
    - 문제 내용 : 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력.
    - POINT : 
    ```java 
    //입력받을 문장일 경우 : nextLine
        String str = kb.nextLine();

    //해결법 1
        String[] strArray = str.split(" ");

    //해결법 2
        while((pos=str.indexOf(" "))!=-1){}
    ```

4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기) - ***RevertString.java***
    - 문제 내용 : 입력받은 문자열 뒤집기
    - POINT : 
    ```java 
    /* 
    StringBuilder : 메서드 체인을 사용함
       String 자체는 값이 내부적으로 변경되기 어려움 객체를 계속 변경되어야 함
       StringBuilder 만들어진 객체 1개로 내부적으로 변경이 가능, 
       메모리 누수없이 문자열 변경이 가능
    */
        String sb = new StringBuilder(x).reverse().toString();
    ```

5. 특정 문자 뒤집기(toCharArray()) - ***ReverseSpecificString.java***
    - 문제 내용 : 입력받은 문자열 뒤집기, **알파벳 만**
    - POINT : 
    ```java 
    //Character의 하위 메서드 isLetter
        while (start < end){
            if(!Character.isLetter(strCharArray[start])){
                start++;
                continue;
            }
            if(!Character.isLetter(strCharArray[end])){
                end--;
                continue;
            }
        }
    ```

6. 중복문자제거 - ***RmDupChar.java***
    - 문제 내용 : 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거
    - POINT : 
    ```java 
    //String.indexOf(String param) : 항상 제일 앞에 있는 문자열의 인덱스만 찍음
        String str = "testData";
         
        /* 중략 */    

    //String.indexOf(String param) : 항상 제일 앞에 있는 문자열의 인덱스만 찍음
        if(str.indexOf(str.charAt(i)) != i){
            continue; //PASS
        }
    ```
7. 회문문자열 - ***IsPalindrome.java***
    - 문제 내용 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열 확인
    - POINT : 
    ```java 
    // 해결법 1
        String tmp = new StringBuilder(str).reverse().toString();

    // 해결법 2
        int start = 0;
        int end = str.length()-1;
        // 중간에서 만나
        while(start < end){
            start++;
            end--;
        }
    ```
8. 팰린드롬(replaceAll 정규식이용) - ***IsPalindromeOnlyAlphabet.java***
    - 문제 내용 : 회문확인, **알파벳 만**
    - POINT : 
    ```java 
    //알파벳 이외의 문자들의 무시합니다. (!) regex는 정규표현식의 약자다.
        String regex = "[^a-zA-Z]";
        String onlyAlphabet = str.replaceAll(regex, "");
    
        String reverseOnlyAlphabet = 
                    new StringBuilder(onlyAlphabet).reverse().toString();

    ```
9. 숫자만 추출 - ***FilterNumber.java***
    - 문제 내용 : 입력받은 문자열에 숫자만 추출
    - POINT : 
    ```java 
    //Character의 하위 메서드 isDigit
        Character.isDigit(x)
    ```

10. 문자거리 - ***ShortCharLength.java***
    - 문제 내용 : [ 제일 어려웠던 문제 ] 특정 문자와 제일 가까운 거리 구하기
    - POINT : 
    ```java 
    // 작은 값을 비교 하기 위한 셋팅
        int p = 1000; 
    // 정방향으로
        for(int i = 0; i < charArr.length; i++){ /* 중략 */ }
    // 작은 값을 비교 하기 위한 셋팅 초기화        
        p = 1000;
    // 역방향으로
        for(int i = charArr.length-1; i > -1; i--)){ /* 중략 */ }
    ```

11. 문자열 압축 - ***StringCompress.java***
    - 문제 내용 : 반복되는 문자열의 압축처리 및 반복 갯수 표현
    - POINT : 
    ```java 
    // 시작 지점
        String answer = String.valueOf(str.charAt(0));
        char before = str.charAt(0);

    // 초기화를 언제 하는 게 맞을까?
        int p = 1; 

    // 마무리 지점
        if(p>1){}

    ```
12. 암호(replace(), parseInt(string, 2)) - ***Password.java***
    - 문제 내용 : 암호문을 이진수로 십진수로 아스키코드로 문자로 **바꿈**
    - POINT : 
    ```java 
    // 서브스트링은 항상 헷갈린다.
        String binary = cipher.substring(i*7,(i+1)*7)
                              .replace("#", "1")
                              .replace("*", "0");
        
    // 2진수를 -> 10진수 변환하는 방법
        int ascii = Integer.parseInt(binary, 2);
        
        // cf) 10진수 -> 2진수 변환하는 방법
        // Integer.toBinaryString(100);

    // 아스키 코드 -> character 변환 처리 
        answer += (char)ascii;
    ```