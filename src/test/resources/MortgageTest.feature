#language: ru
Функционал: Ипотека


  Сценарий: Ипотека на готовое жильё

  Когда выбран пункт меню "Ипотека"
  И выбран подпункт меню "Ипотека на готовое жильё"
  И выполнена прокрутка страницы до полей ввода


  Когда заполняются поля:
   |Стоимость недвижимости|5180000|
   |Первоначальный взнос|3058000|
   |Срок кредита|30|
    И выполнено переключение наличия зарплатной карты

  Тогда значения полей равны:
    |Сумма кредита|2 122 000 ₽|
    |Ежемесячный платёж|18 937 ₽|
    |Необходимый доход|31 561 ₽|
    |Процентная ставка|11 %|
