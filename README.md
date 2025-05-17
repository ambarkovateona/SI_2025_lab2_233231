# SI_2025_lab2_233231
## Теона Амбаркова 233231
### Control flow graph
Цикломатската комлексност изнесува 9. Ова е добиено според формулата: број на предикатни јазли + 1. Во ова сценарио бројот на предикатни јазли е 8, такашто се добива 9.
 ![233231](https://github.com/user-attachments/assets/40df080e-63a4-4747-993e-e7f4a8b2e5ea)

### Тест случаи според критериумот Every Statement
Во мојот случај, јас напишав 10 test cases.
Потребни се минимум 5 тест случаи за покривање на секој statement од кодот.
1. Листата allItems е null	allItems = null ->	RuntimeException: "allItems list can't be null!"
2. Првиот елемент е Item со null име	->	RuntimeException: "Invalid item!"
3. Првиот елемент е Item со празно ("") име	->	RuntimeException: "Invalid item!"
4.	Еден производ со цена >300 (price = 400), без попуст, количина 1 ->	Вкупна цена = −30 + 400×1 = 370
5.	Еден евтин производ (price = 100) со 10% попуст, количина 2
6.	Количина > 10 (11 единици), без попуст и price = 100	->	Вкупна цена = −30 + 100×11 = 1070
7.	Количина 2, цена < 300, без попуст ->	Вкупна цена = 2×100 = 200
8.	Koличина 1, цена < 300, без попуст
9.	Валиден ред, но број на картичка краток (length < 16)	
cardNumber = "1234"	->  RuntimeException("Invalid card number!")
10.	Валиден ред, но картичката содржи не‑цифрен карактер	
cardNumber = "12345678901234AB"-> RuntimeException("Invalid character in card number!")
    
### Тест случаи според критериумот Multiple Conditions
Според овој критериум, потребни се минимално 4 тест случаи ( само price>300 го прави OR вистинито
F	T	F	само discount>0 го прави OR вистинито
F	F	T	само quantity>10 го прави OR вистинито
F	F	F	сите три се false → условот е false).
Односно, преку тие тестови ќе се покрие секоја можност, и кога би можело да го исполни и да не го исполни условот.
Јас имам 8: 
1. qty=1, price=100, disc=0	FFF
2.	qty=1, price=400, disc=0	FTF
3.	qty=1, price=100, disc=0.2	FFT
4. qty=11, price=100, disc=0	TFF
5.	qty=1, price=400, disc=0.1	FTT
6.	qty=11, price=400, disc=0	TTF
7.	qty=11, price=100, disc=0.1	TFT
8.	qty=11, price=400, disc=0.2 TTT
   
### Објаснување за напишаните unit tests:
#### Every statement:
Зошто ги одбрав овие test cases:
1. Со првиот test case се проверува дали листата е null, и со самото тоа се покрива делот од кодот кадешто фрла исклучок ("allItems list can't be null!").
2. Вториот и третиот проверуваат дали името е null/празно име, со тоа се покрива оној дел кадешто фрла RuntimeException("Invalid item!").
3. Четвртиот, како и шестиот тест случај (ItemA, ItemC) го исполнуваат условот  if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10), и поради тоа е покриен и оној statement каде sum -=30, но не влегува во вториот услов каде discount треба да биде >0.
4. ItemB ги покрива условите if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10) и if (item.getDiscount() > 0).
5. ItemD и ItemE влегуваат во else делот (не ги исполнуваат претходните два услови, имаат цена<300, попуст=0, количина<10).
6. Понатаму, следниот тест случај влегува во else бидејќи не е исполнет условот if (cardNumber != null && cardNumber.length() == 16).
7. И уште еден тест случај со кој се покрива делот кадешто има invalid character во картичката if (allowed.indexOf(c) == -1) {
                    throw new RuntimeException("Invalid character in card number!");
   }.
   
#### Multiple condition:
Jaс имам 8 тест случаи (2^3 = 8), a преку тоа се опфатени сите сценарија (FFF, FFT, FTF, TFF, TTT, TTF, TFT, FTT).


