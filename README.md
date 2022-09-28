# AlgorithmWithJava


## ※ 알고리즘 공부의 방향성 찾기
 1. 다음 부터는 공부 할때 항상 노트랑 팬을 들고 공부를 하자.
 2. 10분 고민 뒤 바로 생각안나면 찾아보자 (나는 쌓여 있는게 없다. 시간도 부족하다.)
 3. 근데 아무리 생각해 봐도 이 책은 수준이 좀 높은게 아닐까 싶다. 일단 지금 이 파트는 너무 어렵다. 일단 급한 정렬 알고리즘 부터 본다. 복잡한 수식은 일단 재껴 놓는게 필요
 4. 이 책 문제점이 알고리즘 연습문제에 대한 풀이가 없다. 연습문제는 주말에 몰아서 풀어야 할듯 진도 위주 진행. part2완료.
 5. 대학 교재라서 그런지 연습문제 풀이도 없고, 책에 있는 코드 그대로 수행해도 무한 루프가 발생한다. 아무리 생각해도 책을 잘못 고른것 같다. 젠장.
 6. 일단 확인 결과 내 잘못도 있었고 책의 잘못도 있었다. 일단 책을 한번 읽어 보고 접근하니 문제가 보이기 시작하고 디버깅이 가능해졌다. 
 7. 일단 실전에는 크게 도움이 되지 않을 거라는 걸 알지만, 정렬 알고리즘에 대해 깊게 공부를 진행해 보기로 하였다. 모두의 알고리즘 파이썬의 책을 보면 선택정렬, 삽입정렬, 힙정렬 외에도 병합정렬, 퀵정렬이 포함되어 있어 해당 하는 정렬도 따로 추가로 공부할 계획이다.
 8. 결국은 이 책을 정복하지 못하면 다음이 없다. 대학교 교재이지만 수 많은 컴공 대학생들도 이걸 공부하고 시험치며 이 단계를 넘어 갔다. 기초인 것이다. 여기서 부족한 부분을 찾아내고 내것으로 만들어야 다음을 생각하고 다음을 구성할 수 있다. 그저 그런 개발자가 되고 싶지 않다. 시간이 걸리더라도 꼭 이걸 꼭 내것으로 만들고 스스로 진화하고 싶다.
- 20220926
 9. 방법을 바꾸기로 했다. 책 하나의 독학으로는 뭔가 부족하다. 책읽다 시간이 다간다. 실전 감각도 없는 것 같다. 시험문제를 보는데 시간도 많이 든다. 인프런의 강의를 결재했다. 
 10. 인프런 : 자바(Java) 알고리즘 문제풀이를 결제 했다. (77,000 원) 결과가 어떠하든 무조건 완강을 할 생각이다. 이 기초가 부족하기에 이 단계를 넘어 서야만 한다.
 11. 인강 만큼이나 중요한 것은 지난날 스스로 공부했던 프로젝트에 대한 복기다. 


___
### 하기 전 git 복습

```git
cd "리포지토리에올린경로"

git init

git remote add orign "github리포지토리주소"

git pull origin master
#요즘이는 master보다 main을 주로 쓰는 듯. 깃헙에서 세팅을 해야 되는 모양

# git commit 절차
git add --all
git commit -m "커밋메세지"
git push origin master

# .gitignore 적용
git rm -r --cached . 
git add .
git commit -m "Apply .gitignore"

```