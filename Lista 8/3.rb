class Jawna
	def initialize(text)
		@text = text
	end

	def zaszyfruj(klucz)
		return Zaszyfrowana.new(@text.each_char.map{|char| ((char.ord + klucz) % 256).chr}.join(''))
	end

	def to_s
		return @text
	end
end

class Zaszyfrowana
	def initialize(text)
		@text = text
	end

	def odszyfruj(klucz)
		return Jawna.new(@text.each_char.map{|char| ((char.ord - klucz) % 256).chr}.join(''))
	end

	def to_s
		return @text
	end
end

jawna = Jawna.new("Ala ma kota")
puts jawna
zaszyfrowana = jawna.zaszyfruj(3)
puts zaszyfrowana
odszyfrowana = zaszyfrowana.odszyfruj(3)
puts odszyfrowana
