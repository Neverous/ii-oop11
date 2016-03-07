class Kolekcja
	class Element
		def initialize(val, prv = nil, nxt = nil)
			@prev = prv
			@next = nxt
			@value = val
		end

		def next
			return @next
		end

		def next=(nxt)
			@next = nxt
		end

		def prev
			return @prev
		end

		def prev=(prv)
			@prev = prv
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

	def get(i)
		act = @root
		while i > 0 and act
			i -= 1
			act = act.next
		end

		return act.value
	end

	def add(val)
		if not @root
			@root = Element.new(val)
			return
		end

		if @root.value > val
			@root = Element.new(val, nil, @root)
			return
		end

		act = @root
		while act.next and act.next.value < val
			act = act.next
		end

		act.next = Element.new(val, act.prev, act.next)
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
end

class Wyszukiwanie
	def znajdz1(data, elem)
		s = 0
		e = data.length - 1
		if elem > data.get(e) or elem < data.get(s)
			return nil
		end

		while s <= e
			mid = (s + e) / 2
			midv = data.get(mid)
			if midv < elem
				s = mid + 1

			elsif midv > elem
				e = mid - 1

			else
				return midv

			end
		end

		return nil
	end

	def znajdz2(data, elem)
		s = 0
		e = data.length - 1
		if elem > data.get(e) or elem < data.get(s)
			return nil
		end

		while s < e
			mid = s + (e - s) * (elem - data.get(s)) / (data.get(e) - data.get(s))
			midv = data.get(mid)
			if midv < elem
				s = mid + 1

			elsif midv > elem
				e = mid - 1

			else
				return midv

			end
		end

		return nil
	end
end

dane = Kolekcja.new
szukaj = Wyszukiwanie.new
dane.add(3)
dane.add(5)
dane.add(4)
dane.add(2)
dane.add(1)
(0..dane.length - 1).each do |i|
	puts dane.get(i)
end

puts szukaj.znajdz1(dane, 4), szukaj.znajdz2(dane, 4), szukaj.znajdz1(dane, 0), szukaj.znajdz2(dane, 25)
puts szukaj.znajdz1(dane, 2), szukaj.znajdz2(dane, 3), szukaj.znajdz1(dane, 1), szukaj.znajdz2(dane, 5)
