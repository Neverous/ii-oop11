class Kolekcja2
	def initialize
		@data = []
	end

	def length
		return @data.length
	end

	def get(i)
		return @data[i]
	end

	def add(val)
		@data <<= val
	end

	def swap(i, j)
		@data[i], @data[j] = @data[j], @data[i]
	end
end

class Kolekcja
	class Element
		def initialize(val, nxt = nil)
			@next = nxt
			@value = val
		end

		def next
			return @next
		end

		def value
			return @value
		end

		def value=(val)
			@value = val
		end
	end

	def initialize
		@root = nil
	end

	def empty?
		return @root == nil
	end

	def _get(i)
		act = @root
		while i > 0 and act
			i -= 1
			act = act.next
		end

		return act
	end

	def get(i)
		return self._get(i).value
	end

	def add(val)
		new = Element.new(val, @root)
		@root = new
	end

	def length
		len = 0
		act = @root
		while act
			len += 1
			act = act.next
		end

		return len
	end

	def swap(i, j)
		eI = self._get(i)
		eJ = self._get(j)
		eI.value, eJ.value = eJ.value, eI.value
	end
end

class Sortowanie
	# sortowanie przez wstawianie
	def sort1(data)
		i = 1
		while i < data.length
			j = i
			while j > 0 and data.get(j) < data.get(j - 1)
				data.swap(j, j - 1)
				j -= 1
			end

			i += 1
		end
	end

	# sortowanie babelkowe
	def sort2(data)
		did = true
		len = data.length
		while did
			did = false
			for i in 1...len
				if data.get(i - 1) > data.get(i)
					data.swap(i - 1, i)
					did = true
				end
			end
			len -= 1
		end
	end
end

dane = Kolekcja2.new
dane2 = Kolekcja2.new
dane3 = Kolekcja.new
dane.add(5)
dane.add(3)
dane.add(4)
dane.add(2)
dane.add(1)
dane2.add(5)
dane2.add(3)
dane2.add(4)
dane2.add(2)
dane2.add(1)
dane3.add(1)
dane3.add(2)
dane3.add(4)
dane3.add(3)
dane3.add(5)
puts dane.get(3), dane2.get(3), dane3.get(3)
sortowania = Sortowanie.new
sortowania.sort1(dane)
sortowania.sort2(dane2)
sortowania.sort2(dane3)
puts dane.get(3), dane2.get(3), dane3.get(3)
