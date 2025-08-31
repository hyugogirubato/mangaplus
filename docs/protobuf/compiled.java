package jp.co.comic.jump.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import jp.co.comic.jump.proto.BannerOuterClass;
import jp.co.comic.jump.proto.PopupOuterClass;
import jp.co.comic.jump.proto.ServiceAnnouncementOuterClass;
import jp.co.comic.jump.proto.TitleListGroup;
import jp.co.comic.jump.proto.TitleListOuterClass;
import jp.co.comic.jump.proto.UpdatedTitleGroupOuterClass;

/* loaded from: classes5.dex */
public final class ExampleViewOuterClass {

    public interface ExampleViewOrBuilder extends MessageLiteOrBuilder {
        TitleListOuterClass.TitleList getFeaturedTitleLists(int i);

        int getFeaturedTitleListsCount();

        List<TitleListOuterClass.TitleList> getFeaturedTitleListsList();

        UpdatedTitleGroupOuterClass.UpdatedTitleV2Group getGroups(int i);

        int getGroupsCount();

        List<UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> getGroupsList();

        PopupOuterClass.Popup getPopup();

        TitleListGroup.TitleRankingGroup getRankedTitles(int i);

        int getRankedTitlesCount();

        List<TitleListGroup.TitleRankingGroup> getRankedTitlesList();

        ServiceAnnouncementOuterClass.ServiceAnnouncement getServiceAnnouncements(int i);

        int getServiceAnnouncementsCount();

        List<ServiceAnnouncementOuterClass.ServiceAnnouncement> getServiceAnnouncementsList();

        BannerOuterClass.Banner getTopBanners(int i);

        int getTopBannersCount();

        List<BannerOuterClass.Banner> getTopBannersList();

        boolean hasPopup();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ExampleViewOuterClass() {
    }

    public static final class ExampleView extends GeneratedMessageLite<ExampleView, Builder> implements ExampleViewOrBuilder {
        private static final ExampleView DEFAULT_INSTANCE;
        public static final int FEATURED_TITLE_LISTS_FIELD_NUMBER = 5;
        public static final int GROUPS_FIELD_NUMBER = 2;
        private static volatile Parser<ExampleView> PARSER = null;
        public static final int POPUP_FIELD_NUMBER = 4;
        public static final int RANKED_TITLES_FIELD_NUMBER = 3;
        public static final int SERVICE_ANNOUNCEMENTS_FIELD_NUMBER = 6;
        public static final int TOP_BANNERS_FIELD_NUMBER = 1;
        private int bitField0_;
        private PopupOuterClass.Popup popup_;
        private Internal.ProtobufList<BannerOuterClass.Banner> topBanners_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> groups_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<TitleListGroup.TitleRankingGroup> rankedTitles_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<TitleListOuterClass.TitleList> featuredTitleLists_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<ServiceAnnouncementOuterClass.ServiceAnnouncement> serviceAnnouncements_ = GeneratedMessageLite.emptyProtobufList();

        private ExampleView() {
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public List<BannerOuterClass.Banner> getTopBannersList() {
            return this.topBanners_;
        }

        public List<? extends BannerOuterClass.BannerOrBuilder> getTopBannersOrBuilderList() {
            return this.topBanners_;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public int getTopBannersCount() {
            return this.topBanners_.size();
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public BannerOuterClass.Banner getTopBanners(int i) {
            return this.topBanners_.get(i);
        }

        public BannerOuterClass.BannerOrBuilder getTopBannersOrBuilder(int i) {
            return this.topBanners_.get(i);
        }

        private void ensureTopBannersIsMutable() {
            Internal.ProtobufList<BannerOuterClass.Banner> protobufList = this.topBanners_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.topBanners_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTopBanners(int i, BannerOuterClass.Banner banner) {
            banner.getClass();
            ensureTopBannersIsMutable();
            this.topBanners_.set(i, banner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTopBanners(BannerOuterClass.Banner banner) {
            banner.getClass();
            ensureTopBannersIsMutable();
            this.topBanners_.add(banner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTopBanners(int i, BannerOuterClass.Banner banner) {
            banner.getClass();
            ensureTopBannersIsMutable();
            this.topBanners_.add(i, banner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTopBanners(Iterable<? extends BannerOuterClass.Banner> iterable) {
            ensureTopBannersIsMutable();
            AbstractMessageLite.addAll(iterable, this.topBanners_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTopBanners() {
            this.topBanners_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTopBanners(int i) {
            ensureTopBannersIsMutable();
            this.topBanners_.remove(i);
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public List<UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> getGroupsList() {
            return this.groups_;
        }

        public List<? extends UpdatedTitleGroupOuterClass.UpdatedTitleV2GroupOrBuilder> getGroupsOrBuilderList() {
            return this.groups_;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public int getGroupsCount() {
            return this.groups_.size();
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public UpdatedTitleGroupOuterClass.UpdatedTitleV2Group getGroups(int i) {
            return this.groups_.get(i);
        }

        public UpdatedTitleGroupOuterClass.UpdatedTitleV2GroupOrBuilder getGroupsOrBuilder(int i) {
            return this.groups_.get(i);
        }

        private void ensureGroupsIsMutable() {
            Internal.ProtobufList<UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> protobufList = this.groups_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.groups_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroups(int i, UpdatedTitleGroupOuterClass.UpdatedTitleV2Group updatedTitleV2Group) {
            updatedTitleV2Group.getClass();
            ensureGroupsIsMutable();
            this.groups_.set(i, updatedTitleV2Group);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroups(UpdatedTitleGroupOuterClass.UpdatedTitleV2Group updatedTitleV2Group) {
            updatedTitleV2Group.getClass();
            ensureGroupsIsMutable();
            this.groups_.add(updatedTitleV2Group);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addGroups(int i, UpdatedTitleGroupOuterClass.UpdatedTitleV2Group updatedTitleV2Group) {
            updatedTitleV2Group.getClass();
            ensureGroupsIsMutable();
            this.groups_.add(i, updatedTitleV2Group);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllGroups(Iterable<? extends UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> iterable) {
            ensureGroupsIsMutable();
            AbstractMessageLite.addAll(iterable, this.groups_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroups() {
            this.groups_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeGroups(int i) {
            ensureGroupsIsMutable();
            this.groups_.remove(i);
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public List<TitleListGroup.TitleRankingGroup> getRankedTitlesList() {
            return this.rankedTitles_;
        }

        public List<? extends TitleListGroup.TitleRankingGroupOrBuilder> getRankedTitlesOrBuilderList() {
            return this.rankedTitles_;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public int getRankedTitlesCount() {
            return this.rankedTitles_.size();
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public TitleListGroup.TitleRankingGroup getRankedTitles(int i) {
            return this.rankedTitles_.get(i);
        }

        public TitleListGroup.TitleRankingGroupOrBuilder getRankedTitlesOrBuilder(int i) {
            return this.rankedTitles_.get(i);
        }

        private void ensureRankedTitlesIsMutable() {
            Internal.ProtobufList<TitleListGroup.TitleRankingGroup> protobufList = this.rankedTitles_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.rankedTitles_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRankedTitles(int i, TitleListGroup.TitleRankingGroup titleRankingGroup) {
            titleRankingGroup.getClass();
            ensureRankedTitlesIsMutable();
            this.rankedTitles_.set(i, titleRankingGroup);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRankedTitles(TitleListGroup.TitleRankingGroup titleRankingGroup) {
            titleRankingGroup.getClass();
            ensureRankedTitlesIsMutable();
            this.rankedTitles_.add(titleRankingGroup);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRankedTitles(int i, TitleListGroup.TitleRankingGroup titleRankingGroup) {
            titleRankingGroup.getClass();
            ensureRankedTitlesIsMutable();
            this.rankedTitles_.add(i, titleRankingGroup);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRankedTitles(Iterable<? extends TitleListGroup.TitleRankingGroup> iterable) {
            ensureRankedTitlesIsMutable();
            AbstractMessageLite.addAll(iterable, this.rankedTitles_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRankedTitles() {
            this.rankedTitles_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRankedTitles(int i) {
            ensureRankedTitlesIsMutable();
            this.rankedTitles_.remove(i);
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public boolean hasPopup() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public PopupOuterClass.Popup getPopup() {
            PopupOuterClass.Popup popup = this.popup_;
            return popup == null ? PopupOuterClass.Popup.getDefaultInstance() : popup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPopup(PopupOuterClass.Popup popup) {
            popup.getClass();
            this.popup_ = popup;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePopup(PopupOuterClass.Popup popup) {
            popup.getClass();
            PopupOuterClass.Popup popup2 = this.popup_;
            if (popup2 != null && popup2 != PopupOuterClass.Popup.getDefaultInstance()) {
                this.popup_ = PopupOuterClass.Popup.newBuilder(this.popup_).mergeFrom((PopupOuterClass.Popup.Builder) popup).buildPartial();
            } else {
                this.popup_ = popup;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPopup() {
            this.popup_ = null;
            this.bitField0_ &= -2;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public List<TitleListOuterClass.TitleList> getFeaturedTitleListsList() {
            return this.featuredTitleLists_;
        }

        public List<? extends TitleListOuterClass.TitleListOrBuilder> getFeaturedTitleListsOrBuilderList() {
            return this.featuredTitleLists_;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public int getFeaturedTitleListsCount() {
            return this.featuredTitleLists_.size();
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public TitleListOuterClass.TitleList getFeaturedTitleLists(int i) {
            return this.featuredTitleLists_.get(i);
        }

        public TitleListOuterClass.TitleListOrBuilder getFeaturedTitleListsOrBuilder(int i) {
            return this.featuredTitleLists_.get(i);
        }

        private void ensureFeaturedTitleListsIsMutable() {
            Internal.ProtobufList<TitleListOuterClass.TitleList> protobufList = this.featuredTitleLists_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.featuredTitleLists_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFeaturedTitleLists(int i, TitleListOuterClass.TitleList titleList) {
            titleList.getClass();
            ensureFeaturedTitleListsIsMutable();
            this.featuredTitleLists_.set(i, titleList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFeaturedTitleLists(TitleListOuterClass.TitleList titleList) {
            titleList.getClass();
            ensureFeaturedTitleListsIsMutable();
            this.featuredTitleLists_.add(titleList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFeaturedTitleLists(int i, TitleListOuterClass.TitleList titleList) {
            titleList.getClass();
            ensureFeaturedTitleListsIsMutable();
            this.featuredTitleLists_.add(i, titleList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFeaturedTitleLists(Iterable<? extends TitleListOuterClass.TitleList> iterable) {
            ensureFeaturedTitleListsIsMutable();
            AbstractMessageLite.addAll(iterable, this.featuredTitleLists_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFeaturedTitleLists() {
            this.featuredTitleLists_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFeaturedTitleLists(int i) {
            ensureFeaturedTitleListsIsMutable();
            this.featuredTitleLists_.remove(i);
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public List<ServiceAnnouncementOuterClass.ServiceAnnouncement> getServiceAnnouncementsList() {
            return this.serviceAnnouncements_;
        }

        public List<? extends ServiceAnnouncementOuterClass.ServiceAnnouncementOrBuilder> getServiceAnnouncementsOrBuilderList() {
            return this.serviceAnnouncements_;
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public int getServiceAnnouncementsCount() {
            return this.serviceAnnouncements_.size();
        }

        @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
        public ServiceAnnouncementOuterClass.ServiceAnnouncement getServiceAnnouncements(int i) {
            return this.serviceAnnouncements_.get(i);
        }

        public ServiceAnnouncementOuterClass.ServiceAnnouncementOrBuilder getServiceAnnouncementsOrBuilder(int i) {
            return this.serviceAnnouncements_.get(i);
        }

        private void ensureServiceAnnouncementsIsMutable() {
            Internal.ProtobufList<ServiceAnnouncementOuterClass.ServiceAnnouncement> protobufList = this.serviceAnnouncements_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.serviceAnnouncements_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceAnnouncements(int i, ServiceAnnouncementOuterClass.ServiceAnnouncement serviceAnnouncement) {
            serviceAnnouncement.getClass();
            ensureServiceAnnouncementsIsMutable();
            this.serviceAnnouncements_.set(i, serviceAnnouncement);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addServiceAnnouncements(ServiceAnnouncementOuterClass.ServiceAnnouncement serviceAnnouncement) {
            serviceAnnouncement.getClass();
            ensureServiceAnnouncementsIsMutable();
            this.serviceAnnouncements_.add(serviceAnnouncement);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addServiceAnnouncements(int i, ServiceAnnouncementOuterClass.ServiceAnnouncement serviceAnnouncement) {
            serviceAnnouncement.getClass();
            ensureServiceAnnouncementsIsMutable();
            this.serviceAnnouncements_.add(i, serviceAnnouncement);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllServiceAnnouncements(Iterable<? extends ServiceAnnouncementOuterClass.ServiceAnnouncement> iterable) {
            ensureServiceAnnouncementsIsMutable();
            AbstractMessageLite.addAll(iterable, this.serviceAnnouncements_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceAnnouncements() {
            this.serviceAnnouncements_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeServiceAnnouncements(int i) {
            ensureServiceAnnouncementsIsMutable();
            this.serviceAnnouncements_.remove(i);
        }

        public static ExampleView parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ExampleView parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExampleView parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExampleView parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExampleView parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExampleView parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExampleView parseFrom(InputStream inputStream) throws IOException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExampleView parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExampleView parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExampleView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExampleView parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExampleView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExampleView parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExampleView parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExampleView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExampleView ExampleView) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(ExampleView);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ExampleView, Builder> implements ExampleViewOrBuilder {
            private Builder() {
                super(ExampleView.DEFAULT_INSTANCE);
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public List<BannerOuterClass.Banner> getTopBannersList() {
                return Collections.unmodifiableList(((ExampleView) this.instance).getTopBannersList());
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public int getTopBannersCount() {
                return ((ExampleView) this.instance).getTopBannersCount();
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public BannerOuterClass.Banner getTopBanners(int i) {
                return ((ExampleView) this.instance).getTopBanners(i);
            }

            public Builder setTopBanners(int i, BannerOuterClass.Banner banner) {
                copyOnWrite();
                ((ExampleView) this.instance).setTopBanners(i, banner);
                return this;
            }

            public Builder setTopBanners(int i, BannerOuterClass.Banner.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).setTopBanners(i, builder.build());
                return this;
            }

            public Builder addTopBanners(BannerOuterClass.Banner banner) {
                copyOnWrite();
                ((ExampleView) this.instance).addTopBanners(banner);
                return this;
            }

            public Builder addTopBanners(int i, BannerOuterClass.Banner banner) {
                copyOnWrite();
                ((ExampleView) this.instance).addTopBanners(i, banner);
                return this;
            }

            public Builder addTopBanners(BannerOuterClass.Banner.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addTopBanners(builder.build());
                return this;
            }

            public Builder addTopBanners(int i, BannerOuterClass.Banner.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addTopBanners(i, builder.build());
                return this;
            }

            public Builder addAllTopBanners(Iterable<? extends BannerOuterClass.Banner> iterable) {
                copyOnWrite();
                ((ExampleView) this.instance).addAllTopBanners(iterable);
                return this;
            }

            public Builder clearTopBanners() {
                copyOnWrite();
                ((ExampleView) this.instance).clearTopBanners();
                return this;
            }

            public Builder removeTopBanners(int i) {
                copyOnWrite();
                ((ExampleView) this.instance).removeTopBanners(i);
                return this;
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public List<UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> getGroupsList() {
                return Collections.unmodifiableList(((ExampleView) this.instance).getGroupsList());
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public int getGroupsCount() {
                return ((ExampleView) this.instance).getGroupsCount();
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public UpdatedTitleGroupOuterClass.UpdatedTitleV2Group getGroups(int i) {
                return ((ExampleView) this.instance).getGroups(i);
            }

            public Builder setGroups(int i, UpdatedTitleGroupOuterClass.UpdatedTitleV2Group updatedTitleV2Group) {
                copyOnWrite();
                ((ExampleView) this.instance).setGroups(i, updatedTitleV2Group);
                return this;
            }

            public Builder setGroups(int i, UpdatedTitleGroupOuterClass.UpdatedTitleV2Group.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).setGroups(i, builder.build());
                return this;
            }

            public Builder addGroups(UpdatedTitleGroupOuterClass.UpdatedTitleV2Group updatedTitleV2Group) {
                copyOnWrite();
                ((ExampleView) this.instance).addGroups(updatedTitleV2Group);
                return this;
            }

            public Builder addGroups(int i, UpdatedTitleGroupOuterClass.UpdatedTitleV2Group updatedTitleV2Group) {
                copyOnWrite();
                ((ExampleView) this.instance).addGroups(i, updatedTitleV2Group);
                return this;
            }

            public Builder addGroups(UpdatedTitleGroupOuterClass.UpdatedTitleV2Group.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addGroups(builder.build());
                return this;
            }

            public Builder addGroups(int i, UpdatedTitleGroupOuterClass.UpdatedTitleV2Group.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addGroups(i, builder.build());
                return this;
            }

            public Builder addAllGroups(Iterable<? extends UpdatedTitleGroupOuterClass.UpdatedTitleV2Group> iterable) {
                copyOnWrite();
                ((ExampleView) this.instance).addAllGroups(iterable);
                return this;
            }

            public Builder clearGroups() {
                copyOnWrite();
                ((ExampleView) this.instance).clearGroups();
                return this;
            }

            public Builder removeGroups(int i) {
                copyOnWrite();
                ((ExampleView) this.instance).removeGroups(i);
                return this;
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public List<TitleListGroup.TitleRankingGroup> getRankedTitlesList() {
                return Collections.unmodifiableList(((ExampleView) this.instance).getRankedTitlesList());
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public int getRankedTitlesCount() {
                return ((ExampleView) this.instance).getRankedTitlesCount();
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public TitleListGroup.TitleRankingGroup getRankedTitles(int i) {
                return ((ExampleView) this.instance).getRankedTitles(i);
            }

            public Builder setRankedTitles(int i, TitleListGroup.TitleRankingGroup titleRankingGroup) {
                copyOnWrite();
                ((ExampleView) this.instance).setRankedTitles(i, titleRankingGroup);
                return this;
            }

            public Builder setRankedTitles(int i, TitleListGroup.TitleRankingGroup.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).setRankedTitles(i, builder.build());
                return this;
            }

            public Builder addRankedTitles(TitleListGroup.TitleRankingGroup titleRankingGroup) {
                copyOnWrite();
                ((ExampleView) this.instance).addRankedTitles(titleRankingGroup);
                return this;
            }

            public Builder addRankedTitles(int i, TitleListGroup.TitleRankingGroup titleRankingGroup) {
                copyOnWrite();
                ((ExampleView) this.instance).addRankedTitles(i, titleRankingGroup);
                return this;
            }

            public Builder addRankedTitles(TitleListGroup.TitleRankingGroup.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addRankedTitles(builder.build());
                return this;
            }

            public Builder addRankedTitles(int i, TitleListGroup.TitleRankingGroup.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addRankedTitles(i, builder.build());
                return this;
            }

            public Builder addAllRankedTitles(Iterable<? extends TitleListGroup.TitleRankingGroup> iterable) {
                copyOnWrite();
                ((ExampleView) this.instance).addAllRankedTitles(iterable);
                return this;
            }

            public Builder clearRankedTitles() {
                copyOnWrite();
                ((ExampleView) this.instance).clearRankedTitles();
                return this;
            }

            public Builder removeRankedTitles(int i) {
                copyOnWrite();
                ((ExampleView) this.instance).removeRankedTitles(i);
                return this;
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public boolean hasPopup() {
                return ((ExampleView) this.instance).hasPopup();
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public PopupOuterClass.Popup getPopup() {
                return ((ExampleView) this.instance).getPopup();
            }

            public Builder setPopup(PopupOuterClass.Popup popup) {
                copyOnWrite();
                ((ExampleView) this.instance).setPopup(popup);
                return this;
            }

            public Builder setPopup(PopupOuterClass.Popup.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).setPopup(builder.build());
                return this;
            }

            public Builder mergePopup(PopupOuterClass.Popup popup) {
                copyOnWrite();
                ((ExampleView) this.instance).mergePopup(popup);
                return this;
            }

            public Builder clearPopup() {
                copyOnWrite();
                ((ExampleView) this.instance).clearPopup();
                return this;
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public List<TitleListOuterClass.TitleList> getFeaturedTitleListsList() {
                return Collections.unmodifiableList(((ExampleView) this.instance).getFeaturedTitleListsList());
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public int getFeaturedTitleListsCount() {
                return ((ExampleView) this.instance).getFeaturedTitleListsCount();
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public TitleListOuterClass.TitleList getFeaturedTitleLists(int i) {
                return ((ExampleView) this.instance).getFeaturedTitleLists(i);
            }

            public Builder setFeaturedTitleLists(int i, TitleListOuterClass.TitleList titleList) {
                copyOnWrite();
                ((ExampleView) this.instance).setFeaturedTitleLists(i, titleList);
                return this;
            }

            public Builder setFeaturedTitleLists(int i, TitleListOuterClass.TitleList.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).setFeaturedTitleLists(i, builder.build());
                return this;
            }

            public Builder addFeaturedTitleLists(TitleListOuterClass.TitleList titleList) {
                copyOnWrite();
                ((ExampleView) this.instance).addFeaturedTitleLists(titleList);
                return this;
            }

            public Builder addFeaturedTitleLists(int i, TitleListOuterClass.TitleList titleList) {
                copyOnWrite();
                ((ExampleView) this.instance).addFeaturedTitleLists(i, titleList);
                return this;
            }

            public Builder addFeaturedTitleLists(TitleListOuterClass.TitleList.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addFeaturedTitleLists(builder.build());
                return this;
            }

            public Builder addFeaturedTitleLists(int i, TitleListOuterClass.TitleList.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addFeaturedTitleLists(i, builder.build());
                return this;
            }

            public Builder addAllFeaturedTitleLists(Iterable<? extends TitleListOuterClass.TitleList> iterable) {
                copyOnWrite();
                ((ExampleView) this.instance).addAllFeaturedTitleLists(iterable);
                return this;
            }

            public Builder clearFeaturedTitleLists() {
                copyOnWrite();
                ((ExampleView) this.instance).clearFeaturedTitleLists();
                return this;
            }

            public Builder removeFeaturedTitleLists(int i) {
                copyOnWrite();
                ((ExampleView) this.instance).removeFeaturedTitleLists(i);
                return this;
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public List<ServiceAnnouncementOuterClass.ServiceAnnouncement> getServiceAnnouncementsList() {
                return Collections.unmodifiableList(((ExampleView) this.instance).getServiceAnnouncementsList());
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public int getServiceAnnouncementsCount() {
                return ((ExampleView) this.instance).getServiceAnnouncementsCount();
            }

            @Override // jp.co.comic.jump.proto.ExampleViewOuterClass.ExampleViewOrBuilder
            public ServiceAnnouncementOuterClass.ServiceAnnouncement getServiceAnnouncements(int i) {
                return ((ExampleView) this.instance).getServiceAnnouncements(i);
            }

            public Builder setServiceAnnouncements(int i, ServiceAnnouncementOuterClass.ServiceAnnouncement serviceAnnouncement) {
                copyOnWrite();
                ((ExampleView) this.instance).setServiceAnnouncements(i, serviceAnnouncement);
                return this;
            }

            public Builder setServiceAnnouncements(int i, ServiceAnnouncementOuterClass.ServiceAnnouncement.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).setServiceAnnouncements(i, builder.build());
                return this;
            }

            public Builder addServiceAnnouncements(ServiceAnnouncementOuterClass.ServiceAnnouncement serviceAnnouncement) {
                copyOnWrite();
                ((ExampleView) this.instance).addServiceAnnouncements(serviceAnnouncement);
                return this;
            }

            public Builder addServiceAnnouncements(int i, ServiceAnnouncementOuterClass.ServiceAnnouncement serviceAnnouncement) {
                copyOnWrite();
                ((ExampleView) this.instance).addServiceAnnouncements(i, serviceAnnouncement);
                return this;
            }

            public Builder addServiceAnnouncements(ServiceAnnouncementOuterClass.ServiceAnnouncement.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addServiceAnnouncements(builder.build());
                return this;
            }

            public Builder addServiceAnnouncements(int i, ServiceAnnouncementOuterClass.ServiceAnnouncement.Builder builder) {
                copyOnWrite();
                ((ExampleView) this.instance).addServiceAnnouncements(i, builder.build());
                return this;
            }

            public Builder addAllServiceAnnouncements(Iterable<? extends ServiceAnnouncementOuterClass.ServiceAnnouncement> iterable) {
                copyOnWrite();
                ((ExampleView) this.instance).addAllServiceAnnouncements(iterable);
                return this;
            }

            public Builder clearServiceAnnouncements() {
                copyOnWrite();
                ((ExampleView) this.instance).clearServiceAnnouncements();
                return this;
            }

            public Builder removeServiceAnnouncements(int i) {
                copyOnWrite();
                ((ExampleView) this.instance).removeServiceAnnouncements(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExampleView();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဉ\u0000\u0005\u001b\u0006\u001b", new Object[]{"bitField0_", "topBanners_", BannerOuterClass.Banner.class, "groups_", UpdatedTitleGroupOuterClass.UpdatedTitleV2Group.class, "rankedTitles_", TitleListGroup.TitleRankingGroup.class, "popup_", "featuredTitleLists_", TitleListOuterClass.TitleList.class, "serviceAnnouncements_", ServiceAnnouncementOuterClass.ServiceAnnouncement.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExampleView> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ExampleView.class) {
                        try {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        static {
            ExampleView ExampleView = new ExampleView();
            DEFAULT_INSTANCE = ExampleView;
            GeneratedMessageLite.registerDefaultInstance(ExampleView.class, ExampleView);
        }

        public static ExampleView getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExampleView> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: jp.co.comic.jump.proto.ExampleViewOuterClass$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}