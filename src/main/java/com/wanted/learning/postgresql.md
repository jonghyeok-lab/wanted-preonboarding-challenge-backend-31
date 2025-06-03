### JSON vs JSONB
- B는 'better' 약자
#### 저장
- JSON 은 text형태로 저장, JSONB 는 binary format으로 저장
- 그래서, JSONB는 저장할 떄, binary format으로 변환하기 위해 JSON 보다 오버헤드가 있다.

#### 성능
- JSONB가 검색 연산에 빠르다.(텍스트를 파싱 안해도 되니까)

#### 유연성
- JSON은 정확한 텍스트를 보존한다.
- JSONB는 키를 재정렬하거나 공백을 제거한다.

#### 인덱싱
- JSON은 direct indexing 지원 X -> 필드에 직접 적용 불가하다.
- JSONB는 JSON필드에 인덱싱 가능

#### 선택 과정
- JSON
  - INSERT 연산이 많을 때
  - JSON 데이터를 가지고, 복잡한 쿼리를 수행할 필요 없을 때(텍스트를 JSON으로 파싱하는 과정이 발생하기 때문)
  - JSON 원본을 저장하고 싶을 때. ex) 로그
- JSONB
  - 시간이 지남에 따라 업데이트되어 데이터의 추적이 필요한 것.
  - 텍스트로 저장하면 텍스트 통째를 바꿔야 하지만 JSONB는 일부 키만 업데이트 하면 되니까.

#### 참고
  - [JSON vs JSONB](https://www.dbvis.com/thetable/json-vs-jsonb-in-postgresql-a-complete-comparison/)