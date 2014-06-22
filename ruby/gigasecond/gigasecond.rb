class Gigasecond

  GS_IN_DAYS = (10**9)/(60*60*24)

  def initialize (birth_date)
    @birth_date = birth_date
  end

  def date
    @birth_date + GS_IN_DAYS
  end

end