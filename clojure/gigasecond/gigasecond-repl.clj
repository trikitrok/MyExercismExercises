;String dt = "2008-01-01";  // Start date
;SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
;Calendar c = Calendar.getInstance();
;c.setTime(sdf.parse(dt));
;c.add(Calendar.DATE, 1);  // number of days to add
;dt = sdf.format(c.getTime());

(import [java.util Date Calendar]
        [java.text SimpleDateFormat])

(..
 (SimpleDateFormat. "yyyy-MM-dd")
 (parse "2008-01-01"))

(.parse (SimpleDateFormat. "yyyy-MM-dd") "2008-01-01")

(SimpleDateFormat. "yyyy-MM-dd")

(def calendar (Calendar/getInstance))

(.setTime calendar (.parse (SimpleDateFormat. "yyyy-MM-dd") "2008-01-01"))

calendar
(.get calendar (Calendar/YEAR))
(.get calendar (Calendar/MONTH))
(.get calendar (Calendar/DATE))

(.add calendar (Calendar/DATE) 1)

calendar

(.get calendar (Calendar/YEAR))
(.get calendar (Calendar/MONTH))
(.get calendar (Calendar/DATE))


(..
 calendar
 (setTime (.parse (SimpleDateFormat. "yyyy-MM-dd") "2008-01-02")))

calendar


 ;(setTime (.parse (SimpleDateFormat. "yyyy-MM-dd") "2008-01-01"))
 ;(add (Calendar/DATE) 1))