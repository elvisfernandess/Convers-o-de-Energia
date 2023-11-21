clc
clear all

R1=0.095;
X1=0.6800*i;

Rf = 500;
Xm = 18.7*i;

R2=0.300;
X2=0.672*i;

V1 =220;
fe=60;
polos=4;
nr=1750;
Prot=0;

ns=120*fe/polos % b) a velocidade do campo girante (velocidade sincrona)

s=(ns-nr)/ns % a) o escorregamento

%c) a frequencia das correntes induzidas no rotor
fr=s*fe

Z0 = Rf * Xm / (Rf + Xm);
Z1=R1+X1;
Z2=R2+X2+R2.*((1-s)./s);

Z3=(Z2*Z0)./(Z2+Z0);
Zeq=(Z3+Z1);

Ialimentacao=(V1)*(sqrt(3))/Zeq; %d) a corrente de alimentação do motor;
I1=(Ialimentacao)/(sqrt(3));

mod_Ialimentacao_delta = abs(Ialimentacao)
angle_Ialimentacao_delta_rad = angle(Ialimentacao);
angle_Ialimentacao_delta_graus=rad2deg(angle_Ialimentacao_delta_rad);

mod_Ifase_delta = abs(I1);
angle_Ifase_delta_rad = angle(I1);
angle_Ialimentacao_delta_graus=rad2deg(angle_Ifase_delta_rad);

E0=I1*Z3;
% Calculando coordenadas polares
mod_E0 = abs(E0);
angle_E0_rad = angle(E0);
angle_E0_graus=rad2deg(angle_E0_rad);

I2=E0/Z2;
% Calculando coordenadas polares
mod_I2 = abs(I2);
angle_I2_rad = angle(I2);
angle_I2_graus=rad2deg(angle_I2_rad);

P1 = real(V1 * conj(I1));
Pentrada=3*P1 % e) a potência elétrica de entrada do motor;

% f) a potência mecânica entregue ao eixo;
Pconv=3*(mod_I2.^2)*R2*((1-s)/s)
Peixo=Pconv - Prot 

% g) o torque mecânico;
Torque_ind=Pconv/(nr*2*pi/60)
Torque_eixo=Peixo/(nr*2*pi/60)

% h) o rendimento;
Psaida = Peixo
Rendimento=(Psaida/Pentrada)*100


% i) o fator de potência;
FP=cos(angle_Ifase_delta_rad)

% j) para essa condição, o motor esta operando em sobrecarga?;
Pnominal_HP=20 % enunciado
Peixo_HP=Peixo/745.7


if Pnominal_HP < Peixo_HP
    disp('% j) para essa condição, o motor esta operando em sobrecarga?')
    disp('Sim, esta a sobrecarga porque: Pnominal_HP < Peixo_HP' )
end

if Pnominal_HP > Peixo_HP
    disp('% j) para essa condição, o motor esta operando em sobrecarga?')
    disp('Não esta a sobrecarga porque: Pnominal_HP > Peixo_HP ' )
end


nr=0:1:1800;
ns=1800;
s=(ns-nr)./ns; 



figure(1)
plot(nr,Torque_ind)