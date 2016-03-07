class Fixnum
	def prime?
		n = 2
		while n * n < self
			if self % n == 0
				return false
			end

			n += 1
		end

		return true
	end

	def ack(m)
		if self == 0
			return m + 1
		end

		if m == 0
			return (self - 1).ack(1)
		end

		return (self - 1).ack(ack(m - 1))
	end

	def doskonala?
		sum = 0
		n = 1
		while n < self
			if self % n == 0
				sum += n
			end

			n += 1
		end
		
		return sum == self
	end

	def slownie
		slownie = ["zero", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec"]
		if self < 10
			return slownie[self]
		end

		return ((self / 10) ? (self / 10).slownie + " " : "") + (self % 10).slownie

	end
end

puts 5.prime?
puts 6.prime?
puts 2.ack(1)
puts 6.doskonala?
puts 1200.doskonala?
puts 8128.doskonala?
puts 8182.slownie
puts 123.slownie
puts 1200.slownie
puts 0.slownie
