Start Transaction;

Drop Table If Exists happiness;

Create Table happiness(

    id serial,
    country_name varchar(50),
    total_score numeric(5,3),
    dystopia numeric(5,3),
    residual numeric(5,3),
    gdp numeric(5,3),
    corruption numeric(5,3),
    life_expectancy numeric(5,3),
    social_support numeric(5,3),
    generosity numeric(5,3),
    personal_autonomy numeric(5,3),

    Constraint pk_happiness Primary Key(id)

);

Drop Table If Exists happiness_percentage;

Create Table happiness_percentage(

id serial,
country_name varchar(50),
total_score numeric(6,3),
residual_percent numeric(6,3),
gdp_percent numeric(6,3),
corruption_percent numeric(6,3),
life_expectancy_percent numeric(6,3),
social_support_percent numeric(6,3),
generosity_percent numeric(6,3),
personal_autonomy_percent numeric(6,3)

);


Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Finland', 7.756, 2.518, 1.892, 1.258, 0.775, 0.736, 0.109, 0.534);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Denmark', 7.563, 2.226, 1.953, 1.243, 0.777, 0.719, 0.188, 0.532);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Iceland', 7.464, 2.320, 1.936, 1.320, 0.803, 0.718, 0.270, 0.191);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Switzerland', 7.437, 2.153, 2.026, 1.226, 0.822, 0.677, 0.147, 0.461);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Netherlands', 7.359, 2.137, 1.945, 1.206, 0.787, 0.651, 0.271, 0.419);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Luxembourg*', 7.307, 2.042, 2.209, 1.155, 0.790, 0.700, 0.120, 0.388);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Sweden', 7.315, 2.003, 1.920, 1.204, 0.803, 0.724, 0.218, 0.512);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Norway', 7.290, 1.925, 1.997, 1.239, 0.786, 0.728, 0.217, 0.474);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Israel', 7.301, 2.634, 1.826, 1.221, 0.818, 0.568, 0.155, 0.143);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('New Zealand', 7.120, 1.954, 1.852, 1.235, 0.752, 0.680, 0.245, 0.483);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Austria', 7.089, 2.148, 1.931, 1.165, 0.774, 0.623, 0.193, 0.329);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Australia', 7.081, 2.011, 1.900, 1.203, 0.772, 0.676, 0.258, 0.341);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ireland', 6.961, 1.743, 2.129, 1.166, 0.779, 0.627, 0.190, 0.408);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Germany', 6.947, 2.142, 1.924, 1.088, 0.776, 0.585, 0.163, 0.358);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Canada', 6.943, 1.924, 1.886, 1.188, 0.783, 0.659, 0.217, 0.368);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('United States', 6.888, 2.214, 1.982, 1.182, 0.628, 0.574, 0.220, 0.177);



Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Finland', 7.756, 11.609854876814039, 31.927100911238607, 21.22848464394195, 13.077961525480932, 12.4198447519406, 1.8393520080998988, 9.01113736078299);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Denmark', 7.563, 6.907378335949765, 34.065934065934066, 21.68149311006454, 13.553113553113553, 12.541426827141112, 3.279260422117565, 9.27960927960928);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Switzerland', 7.437, 5.760656322454075, 36.133404672730514, 21.86552523631175, 14.660246120920277, 12.074192973069378, 2.6217228464419473, 8.221865525236312);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Netherlands', 7.359, 5.552541146681136, 35.178151564478206, 21.81226261530114, 14.234038705009949, 11.774281063483452, 4.901428829806475, 7.578223910291192);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Luxembourg*', 7.307, 3.870732152638305, 40.33229870366989, 21.08818696366624, 14.42395471973708, 12.78071937191893, 2.190980463757531, 7.0841701661493515);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Sweden', 7.315, 3.154056517775752, 35.00455788514129, 21.95077484047402, 14.63992707383774, 13.199635369188695, 3.974475843208751, 9.334548769371011);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Norway', 7.29, 1.73992673992674, 36.57509157509158, 22.692307692307693, 14.395604395604396, 13.333333333333332, 3.974358974358974, 8.68131868131868);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Israel', 7.301, 14.695668067994882, 33.37598245293365, 22.317675013708648, 14.951562785596781, 10.382014256991408, 2.8331200877353315, 2.6137817583622733);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('New Zealand', 7.12, 2.3440453686200375, 35.00945179584121, 23.34593572778828, 14.215500945179583, 12.854442344045369, 4.631379962192816, 9.130434782608695);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Austria', 7.089, 6.046776953793496, 36.718007225708305, 22.152500475375547, 14.717626925270963, 11.846358623312415, 3.669899220384103, 6.255942194333524);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Australia', 7.081, 3.4469624833365073, 36.183584079223, 22.909921919634357, 14.701961531136927, 12.873738335555133, 4.913349838126071, 6.4940011426394975);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Ireland', 6.961, -1.6955759111284348, 41.492886376924574, 22.724615084778794, 15.182225687000585, 12.21984018709803, 3.7029818748781915, 7.951666341843694);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Germany', 6.947, 6.097322649990229, 37.60015634160641, 21.262458471760798, 15.16513582177057, 11.432479968731679, 3.1854602306038697, 6.996286886847762);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('Canada', 6.943, 1.8384510072364564, 36.88636808136124, 23.234891453158617, 15.313905730490907, 12.88871504009388, 4.244083708194798, 7.197340113436339);
Insert Into happiness_percentage (country_name, total_score, residual_percent, gdp_percent, social_support_percent, life_expectancy_percent, personal_autonomy_percent, generosity_percent, corruption_percent) Values('United States', 6.888, 7.591933570581258, 39.18544879398972, 23.36892052194543, 12.415974693554764, 11.348359035191775, 4.349545274812178, 3.499406880189798);

commit;