####
- 소수점 정확하게 저장할 떄
```angular2html
@Column(name = "weight", precision = 10, scale = 2) // 소수점 포함 10자리, 소수부는 2자리, Double은 안됨
private BigDecimal weight;
```


- Postgresql에 jsonb타입 저장하고 싶을 때
```angular2html
@Column(name = "dimensions", columnDefinition = "jsonb")
@JdbcTypeCode(value = SqlTypes.JSON)
private Map<String, Object> dimensions; / String / @Embedded 다 됨.
```