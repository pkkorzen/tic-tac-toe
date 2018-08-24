﻿Gra w Kółko i krzyżyk powinna powinna się składać z następujących klas:
1. Klasa przechowująca dane o planszy. Powinna zawierać testy:
	- sprawdzający, czy da się utworzyć nową plansze
	- czy nowa plansza zawiera puste wartości
	- czy da się dodać prawidłowy ruch
	- czy da się dodać dwa razy taki sam ruch
	- czy da się dodać nieprawidłowy ruch (rozważyć przypadki podania niepoprawnych koordynatów oraz niepoprawnego symbolu)
	- czy da się pobrać element planszy o prawidłowym adresie
	- czy da się pobrać element planszy o nieprawidłowym adresie
2. Klasę sprawdzającą, czy dana plansza jest już rozwiązana (czy któryś z graczy wygrał). Testy:
	- czy dla pustej planszy metoda sprawdzająca zwraca informacje o tym, że nikt nie wygrał
	- czy jeżeli w którymkolwiek z wierszy są 3 symbole jednego gracza, to czy zwracany jest symbol tego gracza
	- czy jeżeli w którejkolwiek z kolumn są 3 symbole jednego gracza, to czy zwracany jest symbol tego gracza
	- czy jeżeli na którejkolwiek przekątnej są 3 symbole jednego gracza, to czy zwracany jest symbol tego gracza
3. Klasę gracza ludzkiego
	- sprawdzić, czy da się utworzyć taką klasę (rozważyć, czy powinna ona mieć konstruktor bezparametrowy, czy może powinna wymagać jakiejś wartości)
	- czy po wpisaniu wartosci na strumien wejsciowy jest zwracany poprawny adres komórki planszy
4. Klasę gracza automatycznego
	- sprawdzić, czy da się utworzyć taką klasę
	- czy dla różnych przypadków planszy jest zwracany poprawny adres komórki (czy jest w odpowiednim zakresie oraz czy nie próbuje wybrać pola już zajętego)
	BONUS: rozważyć wydzielenie dla graczy wspólnego interface lub klasy abstrakcyjnej
5. Klasę zarządzającą grą
	- sprawdzić, czy da się utworzyć taką klasę (rozważyć, czy powinna ona mieć konstruktor bezparametrowy, czy może powinna wymagać jakiejś wartości)
	- sprawdzić, czy pobiera ruch od gracza
	- sprawdzić, czy pobiera ruchy od graczy naprzemiennie
	- sprawdzić, czy przestaje pobierać ruch od gracza, gdy gra zostanie zakończona (wygrana jednego z graczy lub przez remis)
	- sprawdzic, czy przekazuje pobrane od gracza koordynaty ruchu do planszy
	- sprawdzic, czy przekazuje do planszy prawidłowy symbol gracza
	- sprawdzić, czy po wykonaniu ruchu waliduje wygraną któregoś z graczy
	- sprawdzić, jak reaguje kiedy walidator zwróci symbol jednego z graczy
	- sprawdzić, jak reaguje, kiedy walidator zwróci pustą wartość (zero)
	- sprawdzić, jak reaguje, kiedy skończą się wolne pola
6. Klasę, która wyświetla planszę
	- jak wyświetla planszę, kiedy jest pusta
	- jak wyświetla planszę, kiedy jest całkowicie zapełniona
	- jak wyświetla planszę, kiedy zawiera kilka ustawionych pól
7. Klasę, która wyświetla menu gry
	- sprawdzić, czy wypisuje odpowiednie komunikaty dla użytkownika z menu
	- sprawdzić, czy wykonuje prawidłowe operacje (utworzenie obiektów i przekazanie ich do zależnych klas) po wybraniu opcji nowej gry
8. Klasę, która uruchamia grę (Main)