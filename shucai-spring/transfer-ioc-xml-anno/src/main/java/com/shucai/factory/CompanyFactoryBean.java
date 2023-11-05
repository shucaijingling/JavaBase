package com.shucai.factory;

import com.shucai.pojo.Company;
import org.springframework.beans.factory.FactoryBean;

public class CompanyFactoryBean implements FactoryBean<Company> {

    private String companyInfo;// 公司地址，名称，规模

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Override
    public Company getObject() throws Exception {
        Company company = new Company();
        String[] split = this.companyInfo.split(",");
        company.setName(split[0]);
        company.setAddress(split[1]);
        company.setScale(Integer.parseInt(split[2]));

        return company;
    }

    @Override
    public Class<?> getObjectType() {
        return Company.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
