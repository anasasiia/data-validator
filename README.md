### Hexlet tests and linter status:
[![Actions Status](https://github.com/anasasiia/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/anasasiia/java-project-78/actions) <a href="https://codeclimate.com/github/anasasiia/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/7e4ab0b741f9200c5bbf/maintainability" /></a> <a href="https://codeclimate.com/github/anasasiia/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/7e4ab0b741f9200c5bbf/test_coverage" /></a>

### Description
Data validator is a library with which you can check the correctness of any data. The yup library is taken as the basis for the project.
```
Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("validator is cool"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-5); // false
schema.isValid(5); // true
```
