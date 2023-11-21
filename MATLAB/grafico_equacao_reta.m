% Dados fornecidos
ns = 1200;
nr = 1137;
Torque_eixo_nominal = 50.94;
A = Torque_eixo_nominal ./ (nr - ns)
B = (-A) .* (ns)
nr=0:0.01:1137;

% Gera valores de x
x = nr;

% Calcula os valores correspondentes de y usando a equação da reta
y = -(A .* x + B);

% Plota a reta
figure;
plot(x, y, 'LineWidth', 2);

% Adiciona rótulos e título
xlabel('Velocidade (RPM)');
ylabel('Torque no Eixo Nominal (N.m)');
title('Equação da Reta: Torque no Eixo Nominal em Função da Velocidade');

% Adiciona uma grade ao gráfico
grid on;