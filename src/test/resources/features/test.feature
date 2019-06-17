# language: ru
@test
Функция: Поиск информации

  @success
  Сценарий: Успешный поиск информации
    Тогда Welcome: Mercury Tours
     | логин      | пароль   |
     | tutorial   | tutorial |
    Тогда Find a Flight: Mercury Tours:
    Тогда Select a Flight: Mercury Tours
    Тогда Book a Flight: Mercury Tours
    Тогда Flight Confirmation: Mercury Tours