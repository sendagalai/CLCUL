1111111111111111111111 Implémentation de la méthode du point fixe 1111111111111111111111

def PointFixe(f, x0, epsilon, Nmax):
    x = x0
    k = 0

    while k < Nmax:
        x_next = f(x)
        if abs(x_next - x) < epsilon:
        return x_next, k + 1
        x = x_next
        k += 1

def g(x):
    return x**2 - 3

def f(x):
    return x - g(x)

x0 = 1
epsilon = 10**-7
Nmax = 1000

x_star, iterations = PointFixe(f, x0, epsilon, Nmax)

print("Valeur approchée de la solution:", x_star)
print("Nombre d'itérations:", iterations)


2222222222222222222222 Implémentation de la méthode du point fixe avec relaxation 2222222222222222222222

def PointFixeRelaxation(f, w, x0, epsilon, Nmax):
    x = x0
    k = 0

    while k < Nmax:
        x_next = w * f(x) + (1 - w) * x
        if abs(x_next - x) < epsilon:
            return x_next, k + 1
        x = x_next
        k += 1

    return ValueError("La méthode du point fixe avec relaxation n'a pas convergé après Nmax itérations.")

def g(x):
    return x**2 - 3

def f(x):
    return x - g(x)

w = 1/2
x0 = 1
epsilon = 10**-7
Nmax = 1000

x_star_relax, iterations_relax = PointFixeRelaxation(f, w, x0, epsilon, Nmax)

print("(b) Résultats avec relaxation :")
print("Valeur approchée de la solution:", x_star_relax)
print("Nombre d'itérations:", iterations_relax)

print("\n(c) Résultats avec différentes valeurs de ω :")
for i in range(1, 11):
    w_i = i / 10.0
    x_star_i, iterations_i = PointFixeRelaxation(f, w_i, x0, epsilon, Nmax)
    print(f"Pour ω = {w_i}, le nombre d'itérations nécessaire est : {iterations_i}")


        333333333333333333333 Implémentation de la méthode de Newton 333333333333333333333

def Newton(g, dg, x0, epsilon, Nmax):

    x = x0
    k = 0

    while k < Nmax:
        x_next = x - g(x) / dg(x)
        if abs(x_next - x) < epsilon:
            return x_next, k + 1
        x = x_next
        k += 1

        return ValueError("La méthode de Newton n'a pas convergé après Nmax itérations.")

def g(x):
    return x**2 - 3

def dg(x):
    return 2 * x

x0_values = [1, 2, 4, 8]
epsilon = 10**-7

print("(b) Résultats de la méthode de Newton :")
for x0 in x0_values:
    x_star_newton, iterations_newton = Newton(g, dg, x0, epsilon, Nmax)
    print(f"Pour x0 = {x0}, le nombre d'itérations nécessaire est : {iterations_newton}")

