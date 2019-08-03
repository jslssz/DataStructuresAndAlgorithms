# 时间频度
1、忽略常数项     T(n)=2n+2  ==> T(n)=2n

2、忽略低次项     T(n)=2*n^2+n+2  ==> T(n) =2*n^2

3、高次项系数忽略   T(n)=5*n^6+n+2  ==> T(n) =n^6

# 常见时间复杂度
1、常数阶O(1)
 

2、对数阶O(log2n)
i=1;
n=1024
while(i<n){
    i=i*2;
}

3、线程阶O(n)
for(int i=0;i<n;i++){
    
}

4、线性对数阶O(nlog2n)
for(int i=0;i<n;i++){
    while(i<n){
        i=i*2;
    }
}

5、平方阶O(n^2)
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
       
    }
}
6、立方阶O(n^3)

7、k次方阶O(n^k)

8、指数阶O(2^n)
