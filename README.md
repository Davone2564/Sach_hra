![image](https://github.com/Davone2564/Sach_hra/assets/45235000/a2bc9523-8bbc-4f45-b8ed-1c633ffbf038)
**ŽILINSKÁ UNIVERZITA V ŽILINE**

**FAKULTA RIADENIA A INFORMATIKY**

**INFORMATIKA 2**

Semestrálna práca

Dávid Mičo 5ZYI18

**Školský rok 2020/2021**

**ZADANIE SEMESTRÁLNEJ PRÁCE**

Ako zadanie semestrálnej práce som si vybral stolovú hru **Šach**. Pri semestrálnej práci som riešil problém, ako zobraziť na plátne ľubovoľný obrázok z internetu. Taktiež ma potrápilo naprogramovať pohyby, ktorými sa šachové figúrky pohybujú. Celá semestrálna práca sa mi riešila ľahšie vďaka tomu, že poznám pravidlá šachu a s obľubou si ho raz za čas zahrám.

**UML DIAGRAM BALÍČKOV**

![image](https://github.com/Davone2564/Sach_hra/assets/45235000/ac3572a1-203d-426d-a306-07e205ec42ef)

**UML DIAGRAM TRIED**

![image](https://github.com/Davone2564/Sach_hra/assets/45235000/bfbf381e-1fa8-435f-bf9a-0541069681b5)

**TRIEDY**

Trieda **Policko** obsahuje:

-   6 atribútov: **stvorec** – grafické znázornenie políčka

    **surRiadku** – číslo riadku na ktorom sa dané políčko nachádza na šachovnici

    **surStlpca -** číslo stĺpca na ktorom sa dané políčko nachádza na šachovnici

    **oznacene** – hovorí či je políčko momentálne označené

    **zvyraznene** – hovorí či je políčko momentálne zvýraznené

    **farba** – farba políčka

-   konštruktor **Policko** je parametrický, ako parametre sa zadávajú číslo riadku a stĺpca šachovnice, x – ové a y – ové súradnice daného políčka(štvorca) na šachovnici a nakoniec farba políčka
-   metódu **getFarba** s návratovou hodnotou typu String, ktorá vráti momentálnu farbu políčka
-   metódu **getSurRiadku** s návratovou hodnotou typu int, ktorá vráti číslo riadku šachovnice, na ktorom sa políčko nachádza
-   metódu **getSurStlpca** s návratovou hodnotou typu int, ktorá vráti číslo stĺpca šachovnice, na ktorom sa políčko nachádza
-   metódu **oznac** bez návratovej hodnoty
-   metódu **odznac** bez návratovej hodnoty
-   metódu **zvyrazni** bez návratovej hodnoty
-   metódu **jeOznacene** s návratovou hodnotou typu boolean, ktorá vráti hodnotu true ak je políčko označené
-   metódu **jeZvyraznene** s návratovou hodnotou typu boolean, ktorá vráti hodnotu true, ak je políčko zvýraznené
-   metódu **zobraz** bez návratovej hodnoty, ktorá zobrazí políčko na plátne
-   metódu **skry** bez návratovej hodnoty, ktorá skryje políčko z plátne

Trieda **Figurka** obsahuje:

-   4 atribúty: **rozmer –** rozmer figúrky

    **surRiadku -** číslo riadku na ktorom sa daná figúrka nachádza na šachovnici

    **surStlpca -** číslo stĺpca na ktorom sa daná figúrka nachádza na šachovnici

    **farba –** farba figúrky

-   konštruktor **Figurka** je parametrický, ako parametre sa zadávajú číslo riadku a stĺpca šachovnice a farba figúrky
-   metódu **getRozmer** s návratovou hodnotou typu int
-   metódu **getSurRiadku** s návratovou hodnotou typu int, ktorá vráti číslo riadku šachovnice, na ktorom sa figúrka nachádza
-   metódu **getSurStlpca** s návratovou hodnotou typu int, ktorá vráti číslo stĺpca šachovnice, na ktorom sa figúrka nachádza
-   metódu **getFarba** s návratovou hodnotou typu String, ktorá vráti momentálnu farbu figúrky
-   metóda **setSurRiadku** bez návratovej hodnoty, ktorá nastaví figúrke súradnicu riadku na šachovnici podľa zadaného parametra
-   metóda **setSurStlpca** bez návratovej hodnoty, ktorá nastaví figúrke súradnicu stĺpca na šachovnici podľa zadaného parametra
-   metóda **posunOPolicko** bez návratovej hodnoty, ktorá posunie figúrku o počet políčok po x – ovej a y- ovej osi podľa zadaných parametrov
-   abstraktná metóda **posun** ktorá posunie figúrku na cieľové políčko šachovnice
-   abstraktná metóda **zobraz** bez návratovej hodnoty, ktorá zobrazí figúrku na plátne
-   abstraktná metóda **skry** bez návratovej hodnoty, ktorá skryje figúrku, ak je zobrazená na plátne

Trieda **Hra** obsahuje:

-   4 atribúty: **stav –** vyjadruje aký je momentálne stav hry

    **sachovnica** – šachovnica z ktorej sa skladá hracie pole

    **jeZvolFigurka** – vyjadruje skutočnosť či je zvolená figúrka

    **zvolFigurka –** obsahuje zvolenú figúrku(ak nejaká taká existuje)

-   konštruktor **Hra** je bezparametrický
-   metóda **getStav** s návratovou hodnotou typu StavHry, ktorá vráti aktuálny stav hry
-   metóda **hraj** bez návratovej hodnoty, ktorá spustí hru
-   metóda **urcSuradniceMatice** s návratovou hodnotou int[], ktorá pretransformuje Stringové súradnice na integerové súradnice matice
-   metóda **tahHraca** bez návratovej hodnoty, ktorá vyzve hráča na ťah

**Pravidlá Šachu**

**Šachovú** partiu hrajú dvaja súperi, ktorí premiestňujú svoje figúrky na štvorcovej doske nazývanej ‘šachovnica‘. Hráč s figúrkami svetlej farby (Biely) vykonáva prvý ťah, potom hráči ťahajú striedavo, pričom ďalší ťah vykoná hráč s figúrkami tmavej farby (Čierny). Hráč je ‘na ťahu’ keď jeho súper ‘vykonal’ svoj ťah. Cieľom každého hráča je ‘ohroziť’ súperovho kráľa takým spôsobom, aby súper nemal žiaden prípustný ťah. Hráč, ktorý dosiahne tento cieľ, ‘dal mat’ súperovmu kráľovi a vyhral partiu. Nie je prípustné ponechať svojho kráľa ohrozeného, vystaviť svojho kráľa ohrozeniu a ani brať súperovho kráľa. Súper, ktorého kráľ dostal mat, prehral partiu. Ak vznikne taká pozícia, že ani jeden z hráčov nemôže dať mat súperovmu kráľovi, skončí partia nerozhodne.
