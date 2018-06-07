x <- read.csv("ProcessingTimesT4_5_8.csv",header=T,sep=";")
x <- t(x)
t4 <- as.numeric(x[2,1:100])
t6 <- as.numeric(x[2,101:200])
t8 <- as.numeric(x[2,201:ncol(x)])
par(mar=c(5,6,.8,0)+.9, mgp=c(3.2,1.3,0))
boxplot(t4,t6,t8,col=c("gray93","gray93","gray93"),
        names=c(expression(paste(alpha," = 0.4")),
                expression(paste(alpha," = 0.6")),
                expression(paste(alpha," = 0.8"))), 
        # xlab="Thresholds",ylab="Mean Time for Requests (ms)",
        ylim=c(50,250),las=1,
        cex.lab=2.3, cex.axis=2.2, cex.sub=2.2, ann = FALSE)

title(xlab='Thresholds', line=4, cex.lab=2.4)
title(ylab='Tempo médio por requisição (ms)', line=5, cex.lab=2.4)