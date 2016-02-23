source=~/workspace
for rep in *;do 
	cd $source
	if [ -d $rep/src ];then
		cd $rep/src
		ctags -R
	fi
done

