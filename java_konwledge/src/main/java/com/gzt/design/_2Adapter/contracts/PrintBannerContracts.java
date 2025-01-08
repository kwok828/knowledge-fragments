package com.gzt.design._2Adapter.contracts;

public class PrintBannerContracts extends PrintContracts {
    private BannerContracts bannerContracts;

    public PrintBannerContracts(String string) {
        this.bannerContracts = new BannerContracts(string);
    }

    @Override
    public void printWeak() {
        bannerContracts.showWithPare();
    }

    @Override
    public void printStrong() {
        bannerContracts.showWithAster();
    }
}
