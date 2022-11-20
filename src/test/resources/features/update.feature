# language: ru
@update
Функция: Обновление книги
  Функция должна обновить книгу

  Предыстория:
    Допустим Пользователь обновляет данные книги

  @correct
  Сценарий: Программа обновила книгу
    Если книга имеется в базе данных
    То программа обновляет данные книги

  @fail
  Сценарий: Книга не найдена
    Если пользователь передал не существующий id
    То программа не находит книгу базе данных и выдает ошибку