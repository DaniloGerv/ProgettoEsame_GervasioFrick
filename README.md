# Progetto esame (Gervasio , Frick)

Questo è il progetto d'esame svolto per il corso "Programmazione ad oggetti" a.a 2018/2019 all'interno del corso di laurea di Ingegneria informatica e dell'automazione dell'Università Politecnica delle Marche.

## Pre requisiti

Eclipse con plugin **Spring Tools**


## Avvio del progetto

E' necessario scarica il progetto e importarlo nella propria workspace di Eclipse.
Aggiungere nel *build path* le librerie contenute all'interno della cartella *lib*.


## Modellazione dei dati

Il seguente schema UML fornisce la modellazione dei dati adottata per implementare il dataset fornito per il progetto.

- [Class Diagram](https://ibb.co/NyVfCqq)

- [Use Case Diagram](https://ibb.co/NyVfCqq)

- [Sequence Diagram](https://ibb.co/NyVfCqq)

## Gestione dei dati

Il programma memorizza i dati scaricati dal dataset all'interno del file *dataFile.csv* nella cartella del progetto.
All'interno è presente anche il file *metaData.csv* contenente le informazioni relative ai meta dati utilizzati per effettuare la modellizzazione del dataset. Il suddetto file è stato scritto direttamente dai progettisti.

## Controller

Sono presenti due controller principali: **HotelController** e **MetaDataController**. Ognuno di questi fa riferimento alla propria repository (**HotelRepository**,**MetaDataRepository**) le quali inizializzano le informazioni in delle collection, prelevandole dal rispettivo file csv (*metaData.csv* e *dataFile.csv*).

Ciascun controller mette a disposizione delle API accessibili, dopo aver avviato il progetto, all'indirizzo:

```bash
http://localhost:8080/
```


## API

```bash
'MetaDataController'

/metadata #restituisce la lista dei metadata
```

```bash
'HotelController'

/hotel
#restituisce una panoramica delle API disponibili
/hotel/get 
#restituisce la lista di tutti gli hotel disponibili
/hotel/get?filter= 
f#restituisce la lista degli hotel filtrati
/hotel/getByCategoria/{'operator'}/{'value'}
#restituisce gli hotel che soddisfano una data condizione sulla categoria
#se operator='<=' e value='3' sono restituiti tutti gli hotel con categoria<=3
#value è compreso da 1-5 altrimenti viene restituita una pagina di errore
/hotel/stat?fieldStat=
#restituisce una statistica dei dati relativa al campo contenuto nella variabile fieldstat.
/hotel/stat?fieldStat='value'&filter= 
#restituisce una statistica sui dati filtrati.
```

Il filtro dell'API deve essere implementato in questo modo

```bash
?filter=nomePrimoCampo:primoOperatore:primoValore:OPERATORELOGICO:nomeSecondoCampo: ecc.
```

dove

```bash
'nomePrimoCampo': nome del campo sul quale si vuole effettuare il primo filtro
'primoOperatore': operatore di confronto per il primo filtro (<,>,<=,>=,==)
'primoValore': valore utilizzato per il confronto nel primo filtro
'OPERATORELOGICO': utilizzato per concatenare più filtri (AND o OR)
```

## Servizi

All'interno del package **services** sono state implementate delle classi per la gestione di vari servizi utilizzati dalle repository:

- **FilterService** : per la gestione del filtraggio di una collection.
- **DataDownloader** : per il download dei dati JSON dall'URL e dei dati in formato csv dal secondo URL individuato all'interno del JSON.
- **CsvReader** : per la lettura di un file csv.

- **Utilities** : mette a disposizioni costanti e metodi di utilità utilizzati all'interno del progetto.

## Gestione delle eccezioni

Si sono gestite con i metodi tradizionali (*try-cath*, *throw* ...) le eccezioni all'interno del programma.

Per le eccezioni generate dalle API (causate ad esempio da una digitazione di un filtro non corretto) si è utilizzato un **ExceptionHandler** definito all'interno della classe **WebApiExceptionHandler** all'interno del package *main*

## Librerie  esterne

Si sono utilizzate le seguenti librerie esterne

- **json-simple** : per la gestione dei *JSONObject* all'interno del progetto.

- **univocity-parser** : per effettuare una mappatura automatica tra gli attributi delle entità che modellizzano i dati e il csv *dataFile.csv* contente tali dati.

## Autori
**Danilo Gervasio** --> matricola UNIVPM *S1081519*

**Luciano Frick** --> matricola UNIVPM *S1084207*

## License
[UNIVPM](https://www.univpm.it/)
