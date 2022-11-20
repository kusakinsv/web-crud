# language: ru
@read
Функция: Получение книги
  Функция должна вернуть книгу с запрошенным id

  Предыстория:
    Допустим Пользователь запрашивает данные книги

  @correct
  Сценарий: Программа выдала книгу с id 1
    Если книга c id 1 имеется в базе данных
    То программа возвращает данные книги c id 1

  @fail
  Сценарий: Книга с запрошенным id не найдена
    Если пользователь передал не существующий id 999
    То программа не находит книгу с id 999 в базе данных