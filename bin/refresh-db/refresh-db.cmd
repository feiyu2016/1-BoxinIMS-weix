@echo off
echo [INFO] Re-create the schema and provision the sample data.
echo [INFO] Maven Home %MAVEN_HOME%
pause

cd %~dp0
cd ..
cd ..

set path=D:\Program Files (x86)\apache-maven-3.0.5\bin;%windir%/system32;%path%
call mvn antrun:run -Prefresh-db

cd bin
cd refresh-db
pause