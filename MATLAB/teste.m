clc
clear all

R1=0.095;
X1=0.6800;

Rf = 500;
Xm = 18.7;

R2=0.300;
X2=0.672;

V1=220;

nr=0:1:1800;
ns=1800;
s=(ns-nr)./ns; 

Z0 = 1j+Xm+Rf./(1*j*Xm+Rf);
Z1 = R1+1*j*X1;
Z2=(R2./s)+1*j*X2+R2;


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