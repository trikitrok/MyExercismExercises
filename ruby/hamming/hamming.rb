class Hamming

  def self.compute(strand1, strand2)
    def self.base_distance(base1, base2)
      def self.both_exists?(base1, base2)
        not [base1, base2].any? {|base| base.nil?}
      end
      
      (both_exists?(base1, base2) and base1 != base2) ? 1 : 0
    end

    strand1.chars.zip(strand2.chars).map do |base1, base2| 
      base_distance(base1, base2) 
    end.reduce(:+)
  end

end