clc
clear all


R1=0.22;
X1=0.46;

Rf = 150;
Xm = 32;

R2=0.35;
X2=0.77;

V1=220/sqrt(3);
ns=1200;
nr=0:0.01:ns;
s=(ns-nr)./ns;

Z0 = (Rf.*Xm.*1j)./(Rf+(Xm.*1j));
Z1 = R1+(1j.*X1);
Z2=(R2./s)+1j.*X2;
%Z2=R2+X2.*1.*j+R2.*((1-s)./s);
Z02=(Z0.*Z2)./(Z0+Z2);
Zeq=Z02+Z1;

I1=V1./Zeq; 

figure(1)
plot(nr,I1)

xlabel('Rotação (rad/s)');
ylabel('Corrente de Entrada (A)');
title('Corrente de Entrada em Função da Rotação');
legend('Corrente de Entrada');


% Mostrar informações no console
disp('Informações sobre a Corrente de Entrada:');
disp(['Máximo valor de Corrente de Entrada: ', num2str(max(abs(I1)))]);


E0 = I1.*Z02;
I2 = E0./Z2;

Pconv = 3*abs((I2).^2).*R2.*((1-s)./s);
torqueind=Pconv./(nr.*2.*pi./60);

figure(2)
plot(nr,torqueind)

xlabel('Rotação (rad/s)');
ylabel('Torque Induzido (N.m)');
title('Torque Induzido em Função da Rotação');
legend('Torque Induzido');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
fe=60;
ns=1200;
nr=1137;
Prot=0;

s=(ns-nr)/ns; % a) o escorregamento

Z0 = (Rf.*Xm.*1j)./(Rf+(Xm.*1j));
Z1 = R1+(1j.*X1);
Z2=(R2./s)+1j.*X2;
Z02=(Z0.*Z2)./(Z0+Z2);
Zeq=Z02+Z1;

Ialimentacao_estrela=(V1)./Zeq;
% Calculando coordenadas polares
mod_Ialimentacao_estrela = abs(Ialimentacao_estrela);
angle_Ialimentacao_estrela_rad = angle(Ialimentacao_estrela);
angle_Ialimentacao_estrela_graus=rad2deg(angle_Ialimentacao_estrela_rad);

I1=Ialimentacao_estrela;
% Calculando coordenadas polares
mod_I1 = abs(I1)
angle_I1_rad = angle(I1);
angle_I1_graus=rad2deg(angle_I1_rad);

E0=I1.*Z02;
% Calculando coordenadas polares
mod_E0 = abs(E0);
angle_E0_rad = angle(E0);
angle_E0_graus=rad2deg(angle_E0_rad);

I2=E0/Z2;
% Calculando coordenadas polares
mod_I2 = abs(I2);
angle_I2_rad = angle(I2);
angle_I2_graus=rad2deg(angle_I2_rad);

Pconv=3.*(mod_I2.^2).*R2.*((1-s)./s);
Torque_ind=Pconv./(nr.*2.*pi./60);

P1 = real(V1 .* conj(I1));
Pentrada=3.*P1;

Peixo=Pconv - Prot;
Torque_eixo=Peixo./(nr.*2.*pi./60);

Psaida = Peixo;
Rendimento=(Psaida/Pentrada)*100;

FP=cos(angle_I1_rad);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
fe=60;
ns=1200;
nr=861.8;
Prot=0;

s=(ns-nr)/ns % a) o escorregamento

Z0 = (Rf.*Xm.*1j)./(Rf+(Xm.*1j));
Z1 = R1+(1j.*X1);
Z2=(R2./s)+1j.*X2;
Z02=(Z0.*Z2)./(Z0+Z2);
Zeq=Z02+Z1;

Ialimentacao_estrela=(V1)./Zeq;
% Calculando coordenadas polares
mod_Ialimentacao_estrela = abs(Ialimentacao_estrela);
angle_Ialimentacao_estrela_rad = angle(Ialimentacao_estrela);
angle_Ialimentacao_estrela_graus=rad2deg(angle_Ialimentacao_estrela_rad);

I1=Ialimentacao_estrela;
% Calculando coordenadas polares
mod_I1 = abs(I1)
angle_I1_rad = angle(I1);
angle_I1_graus=rad2deg(angle_I1_rad);

E0=I1.*Z02;
% Calculando coordenadas polares
mod_E0 = abs(E0);
angle_E0_rad = angle(E0);
angle_E0_graus=rad2deg(angle_E0_rad);

I2=E0/Z2;
% Calculando coordenadas polares
mod_I2 = abs(I2)
angle_I2_rad = angle(I2);
angle_I2_graus=rad2deg(angle_I2_rad);

Pconv=3.*(mod_I2.^2).*R2.*((1-s)./s);
Torque_ind=Pconv./(nr.*2.*pi./60)

P1 = real(V1 .* conj(I1));
Pentrada=3.*P1;

Peixo=Pconv - Prot;
Torque_eixo=Peixo./(nr.*2.*pi./60)

Psaida = Peixo;
Rendimento=(Psaida/Pentrada)*100;

FP=cos(angle_I1_rad);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
ns=1200;
nr=1137;
Torque_eixo_nominal=50.94;
A=Torque_eixo_nominal./(nr-ns);
B=-(-A).*(ns);

% Coeficientes da equação quadrática
a = 0.005;
b = -8.6*10^-3;
c = -0.09173;

% Calcula o discriminante
delta = b^2 - 4*a*c;

% Verifica se a equação tem raízes reais
if delta >= 0
    % Calcula as raízes
    x1 = (-b + sqrt(delta)) / (2*a);
    x2 = (-b - sqrt(delta)) / (2*a);

    disp('Raízes reais:');
    disp(['x1 = ', num2str(x1)]);
    disp(['x2 = ', num2str(x2)]);
else
    disp('A equação não possui raízes reais.');
end

fe=60;
ns=1200;
nr=x1;
Prot=0;

s=(ns-nr)/ns % a) o escorregamento

Z0 = (Rf.*Xm.*1j)./(Rf+(Xm.*1j));
Z1 = R1+(1j.*X1);
Z2=(R2./s)+1j.*X2;
Z02=(Z0.*Z2)./(Z0+Z2);
Zeq=Z02+Z1;

Ialimentacao_estrela=(V1)./Zeq;
% Calculando coordenadas polares
mod_Ialimentacao_estrela = abs(Ialimentacao_estrela);
angle_Ialimentacao_estrela_rad = angle(Ialimentacao_estrela);
angle_Ialimentacao_estrela_graus=rad2deg(angle_Ialimentacao_estrela_rad);

I1=Ialimentacao_estrela;
% Calculando coordenadas polares
mod_I1 = abs(I1)
angle_I1_rad = angle(I1);
angle_I1_graus=rad2deg(angle_I1_rad);

E0=I1.*Z02;
% Calculando coordenadas polares
mod_E0 = abs(E0);
angle_E0_rad = angle(E0);
angle_E0_graus=rad2deg(angle_E0_rad);

I2=E0/Z2;
% Calculando coordenadas polares
mod_I2 = abs(I2)
angle_I2_rad = angle(I2);
angle_I2_graus=rad2deg(angle_I2_rad);

Pconv=3.*(mod_I2.^2).*R2.*((1-s)./s);
Torque_ind=Pconv./(nr.*2.*pi./60)

P1 = real(V1 .* conj(I1));
Pentrada=3.*P1;

Peixo=Pconv - Prot;
Torque_eixo=Peixo./(nr.*2.*pi./60)

Psaida = Peixo;
Rendimento=(Psaida/Pentrada)*100

FP=cos(angle_I1_rad);

