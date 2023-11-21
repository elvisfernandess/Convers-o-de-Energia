clc
clear all

R1=0.294;
X1=0.503;

Rf = 617;
Xm = 13.2;

R2=0.144;
X2=0.209;

V1=220./sqrt(3);
ns=1200;
nr=0:0.1:ns;
s=(ns-nr)./ns;

Z0 = (Rf.*Xm.*1j)./(Rf+(Xm.*1j))
Z1 = R1+(1j.*X1);
Z2=(R2./s)+1j.*X2;
%Z2=R2+X2.*1.*j+R2.*((1-s)./s);


Z02=(Z0.*Z2)./(Z0+Z2);
Zeq=Z02+Z1;

I1=V1./Zeq; 

figure(1)
plot(nr,I1)

E0 = I1.*Z02;
I2 = E0./Z2;

Pconv = 3*abs((I2).^2).*R2.*((1-s)./s);
torqueind=Pconv./(nr.*2.*pi./60);

figure(2)
plot(nr,torqueind)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
s=(4.3)./100;
Prot=0;
polos=6;
fe=60;
ns=(120.*fe)./(polos);
nr=(1-s).*ns;

Z0 = (Rf.*Xm.*1j)./(Rf+(Xm.*1j))
Z1 = R1+(1j.*X1);
Z2=(R2./s)+1j.*X2;
Z02=(Z0.*Z2)./(Z0+Z2);
Zeq=Z02+Z1;

Ialimentacao_estrela=V1./Zeq;
% Calculando coordenadas polares
mod_Ialimentacao_estrela = abs(Ialimentacao_estrela)
angle_Ialimentacao_estrela_rad = angle(Ialimentacao_estrela);
angle_Ialimentacao_delta_graus=rad2deg(angle_Ialimentacao_estrela_rad);

I1=Ialimentacao_estrela
% Calculando coordenadas polares
mod_I1 = abs(I1);
angle_I1_rad = angle(I1);
angle_I1_graus=rad2deg(angle_I1_rad)

E0=I1*Z02;
% Calculando coordenadas polares
mod_E0 = abs(E0);
angle_E0_rad = angle(E0);
angle_E0_graus=rad2deg(angle_E0_rad);

I2=E0/Z2;
% Calculando coordenadas polares
mod_I2 = abs(I2);
angle_I2_rad = angle(I2);
angle_I2_graus=rad2deg(angle_I2_rad);

Pconv=3.*(mod_I2.^2).*R2.*((1-s)./s)
Torque_ind=Pconv./(nr.*2.*pi./60)

P1 = real(V1 .* conj(I1));
Pentrada=3.*P1;

Peixo=Pconv - Prot
Torque_eixo=Peixo./(nr.*2.*pi./60)

Psaida = Peixo;

Rendimento=(Psaida/Pentrada)*100;

Peixo_HP=Peixo/745.7;
Pnominal=Peixo_HP;

FP=cos(angle_I1_rad)

Inominal=mod_I1;
