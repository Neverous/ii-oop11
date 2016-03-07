class Funkcja
	def initialize(&block)
		@func = block
	end

	def value(x)
		return @func.call(x)
	end

	def poch(x)
		h = 0.1**9
		return (@func.call(x + h) - @func.call(x)) / h
	end

	def zerowe(s, e, eps)
		res = []
		while s <= e
			if @func.call(s).abs < eps
				res <<= s
			end
			s += eps
		end

		if res.empty?
			return nil
		end

		return res
	end

	def pole(s, e)
		parts = 2**20
		width = 1.0 * (e - s) / parts
		res = 0
		while s <= e
			res += width * @func.call(s + width / 2)
			s += width
		end

		return res
	end

	def draw(s, e)
		height = 40
		width = 80
		maxv = -1000000000
		minv = 1000000000
		stepw = 1.0 * (e - s) / width
		act = s
		vals = []
		while act <= e
			val = @func.call(act)
			vals <<= val
			maxv = [maxv, val].max
			minv = [minv, val].min
			act += stepw
		end

		steph = 1.0 * (maxv - minv) / height
		h = 0
		acth = maxv
		while h < height
			w = 0
			actw = s
			while w < width
				if (vals[w] - acth).abs < steph / 2
					print '*'

				elsif actw.abs < stepw / 2 and acth.abs > steph / 2
					print '|'

				elsif actw.abs < stepw / 2 and acth.abs < steph / 2
					print '+'

				elsif acth.abs < steph / 2
					print '-'

				else
					print ' '
				end

				actw += stepw
				w += 1
			end

			puts ''
			acth -= steph
			h += 1
		end
	end
end

sqr = Funkcja.new {|x| x*x - 5}
puts sqr.value(5)
puts sqr.value(7)
puts sqr.zerowe(-20, 20, 0.001)
puts sqr.pole(-5, 5)
puts sqr.poch(7)
sqr.draw(-5, 5)
